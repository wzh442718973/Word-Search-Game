package com.refined.stylish.sanhdieu.presentation.ui.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

import com.refined.stylish.sanhdieu.R;
import com.refined.stylish.sanhdieu.WordSearchApp;
import com.refined.stylish.sanhdieu.databinding.ActivityMainMenuBinding;
import com.refined.stylish.sanhdieu.domain.model.GameRound;
import com.refined.stylish.sanhdieu.presentation.presenters.MainMenuPresenter;
import com.refined.stylish.sanhdieu.presentation.ui.adapter.GameRoundInfoAdapter;
import com.refined.stylish.sanhdieu.presentation.views.MainMenuView;

import java.util.List;

import javax.inject.Inject;

public class MainMenuActivity extends FullscreenActivity implements MainMenuView {

    @Inject
    MainMenuPresenter mPresenter;

    ListView mListView;
    Spinner mGameTempSpinner;
    View mNewGameProgress;
    View mNewGameContent;

    View mLayoutSavedGame;

    int[] mGameRoundDimVals;

    GameRoundInfoAdapter mInfoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainMenuBinding binding = ActivityMainMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        mListView = binding.gameRoundList;
        mGameTempSpinner = binding.gameTemplateSpinner;
        mNewGameProgress = binding.newGameLoadingLayout;
        mNewGameContent = binding.newGameContentLayout;

        mLayoutSavedGame = binding.layoutSavedGame;

        mGameRoundDimVals = getResources().getIntArray(R.array.game_round_dimension_values);


        ((WordSearchApp) getApplication()).getAppComponent().inject(this);

        mInfoAdapter = new GameRoundInfoAdapter(this, R.layout.game_round_item);
        mListView.setAdapter(mInfoAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mPresenter.gameRoundSelected(mInfoAdapter.getItem(position));
            }
        });

        mInfoAdapter.setOnDeleteItemClickListener(new GameRoundInfoAdapter.OnDeleteItemClickListener() {
            @Override
            public void onDeleteItemClick(GameRound.Info info) {
                mPresenter.deleteGameRound(info);
            }
        });

        mPresenter.setView(this);

        binding.newGameBtn.setOnClickListener((view) -> {
            onNewGameClick();
        });
        binding.clearAllBtn.setOnClickListener((view) -> {
            onClearClick();
        });
        binding.settingsButton.setOnClickListener((view) -> {
            onSettingsClick();
        });


        try {
            binding.version.setText("v" + getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
        } catch (Throwable e) {
            
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.loadData();
    }

    public void onNewGameClick() {
        int dim = mGameRoundDimVals[mGameTempSpinner.getSelectedItemPosition()];

        mPresenter.newGameRound(dim, dim);
    }

    public void onClearClick() {
        mPresenter.clearAll();
    }

    @Override
    public void setNewGameLoading(boolean enable) {
        if (enable) {
            mNewGameProgress.setVisibility(View.VISIBLE);
            mNewGameContent.setVisibility(View.INVISIBLE);
        } else {
            mNewGameProgress.setVisibility(View.INVISIBLE);
            mNewGameContent.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showGameInfoList(List<GameRound.Info> infoList) {
        mInfoAdapter.clear();
        mInfoAdapter.addAll(infoList);
        if (infoList.size() <= 0) {
            mLayoutSavedGame.setVisibility(View.INVISIBLE);
        } else {
            mLayoutSavedGame.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showNewlyCreatedGameRound(GameRound gameRound) {
        showGameRound(gameRound.getInfo().getId());
    }

    @Override
    public void showGameRound(int gid) {
        Intent intent = new Intent(this, GamePlayActivity.class);
        intent.putExtra(GamePlayActivity.EXTRA_GAME_ROUND_ID, gid);
        startActivity(intent);

        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    @Override
    public void clearInfoList() {
        final float initXPos = mLayoutSavedGame.getX();
        mLayoutSavedGame.animate()
                .alpha(0.0f)
                .translationX(-mLayoutSavedGame.getWidth())
                .setInterpolator(new AccelerateInterpolator(2.0f))
                .setDuration(250)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        mLayoutSavedGame.setVisibility(View.INVISIBLE);
                        mLayoutSavedGame.setX(initXPos);
                        mLayoutSavedGame.setAlpha(1.0f);
                        mInfoAdapter.clear();
                    }
                });
    }

    @Override
    public void deleteInfo(GameRound.Info info) {
        mInfoAdapter.remove(info);
        if (mInfoAdapter.getCount() <= 0) {
            mLayoutSavedGame.animate()
                    .alpha(0.0f)
                    .setDuration(150)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            mLayoutSavedGame.setVisibility(View.INVISIBLE);
                            mLayoutSavedGame.setAlpha(1.0f);
                        }
                    });
        }
    }

    public void onSettingsClick() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

}
