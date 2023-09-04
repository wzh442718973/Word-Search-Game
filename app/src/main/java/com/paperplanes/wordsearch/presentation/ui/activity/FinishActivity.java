package com.paperplanes.wordsearch.presentation.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.core.app.NavUtils;

import com.paperplanes.wordsearch.R;
import com.paperplanes.wordsearch.WordSearchApp;
import com.paperplanes.wordsearch.commons.DurationFormatter;
import com.paperplanes.wordsearch.databinding.ActivityFinishBinding;
import com.paperplanes.wordsearch.domain.model.GameRoundStat;
import com.paperplanes.wordsearch.presentation.presenters.GameOverPresenter;
import com.paperplanes.wordsearch.presentation.views.GameOverView;

import javax.inject.Inject;


public class FinishActivity extends FullscreenActivity implements GameOverView {
    public static final String EXTRA_GAME_ROUND_ID =
            "com.paperplanes.wordsearch.presentation.ui.activity.FinishActivity";

    @Inject
    GameOverPresenter mPresenter;

    TextView mGameStatText;

    private int mGameId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityFinishBinding binding = ActivityFinishBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mGameStatText = binding.gameStatText;

        ((WordSearchApp) getApplication()).getAppComponent().inject(this);

        mPresenter.setView(this);

        if (getIntent().getExtras() != null) {
            mGameId = getIntent().getExtras().getInt(EXTRA_GAME_ROUND_ID);
            mPresenter.loadData(mGameId);
        }
        binding.mainMenuBtn.setOnClickListener((view)->{
            onMainMenuClick();
        });
    }

    public void onMainMenuClick() {
        goToMainMenu();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        goToMainMenu();
    }

    private void goToMainMenu() {
        if (mPreferences.deleteAfterFinish()) {
            mPresenter.deleteGameRound(mGameId);
        }
        NavUtils.navigateUpTo(this, new Intent());
        finish();

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    @Override
    public void showGameStat(GameRoundStat stat) {
        String strGridSize = stat.getGridRowCount() + " x " + stat.getGridColCount();

        String str = getString(R.string.finish_text);
        str = str.replaceAll(":gridSize", strGridSize);
        str = str.replaceAll(":uwCount", String.valueOf(stat.getUsedWordCount()));
        str = str.replaceAll(":duration", DurationFormatter.fromInteger(stat.getDuration()));

        mGameStatText.setText(str);
    }
}
