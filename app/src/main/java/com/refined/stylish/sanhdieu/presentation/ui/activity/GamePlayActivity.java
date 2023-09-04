package com.refined.stylish.sanhdieu.presentation.ui.activity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.refined.stylish.sanhdieu.R;
import com.refined.stylish.sanhdieu.WordSearchApp;
import com.refined.stylish.sanhdieu.commons.DurationFormatter;
import com.refined.stylish.sanhdieu.commons.Util;
import com.refined.stylish.sanhdieu.config.Preferences;
import com.refined.stylish.sanhdieu.config.SoundManager;
import com.refined.stylish.sanhdieu.databinding.ActivityGamePlayBinding;
import com.refined.stylish.sanhdieu.presentation.custom.LetterBoard;
import com.refined.stylish.sanhdieu.presentation.custom.StreakView;
import com.refined.stylish.sanhdieu.presentation.custom.layout.FlowLayout;
import com.refined.stylish.sanhdieu.presentation.model.UsedWordViewModel;
import com.refined.stylish.sanhdieu.presentation.presenters.GamePlayPresenter;
import com.refined.stylish.sanhdieu.presentation.ui.adapter.ArrayLetterGridDataAdapter;
import com.refined.stylish.sanhdieu.presentation.views.GamePlayView;

import java.util.List;

import javax.inject.Inject;


public class GamePlayActivity extends FullscreenActivity implements GamePlayView {
    public static final String EXTRA_GAME_ROUND_ID =
            "com.refined.stylish.sanhdieusim.presentation.ui.activity.GamePlayActivity";

    @Inject
    Preferences mPref;

    @Inject
    GamePlayPresenter mPresenter;

    @Inject
    SoundManager mSoundManager;

    TextView mTextDuration;
    LetterBoard mLetterBoard;
    FlowLayout mFlowLayout;

    View mTextSelLayout;
    TextView mTextSelection;

    TextView mAnsweredTextCount;
    TextView mWordsCount;

    TextView mFinishedText;

    View mLoading;
    View mContentLayout;

    int mGrayColor;

    private int mGameId;

    private ArrayLetterGridDataAdapter mLetterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityGamePlayBinding binding = ActivityGamePlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mTextDuration = binding.textDuration;
        mLetterBoard = binding.letterBoard;
        mFlowLayout = binding.flowLayout;

        mTextSelLayout = binding.textSelLayout;
        mTextSelection = binding.textSelection;

        mAnsweredTextCount = binding.answeredTextCount;
        mWordsCount = binding.wordsCount;

        mFinishedText = binding.finishedText;

        mLoading = binding.loading;
        mContentLayout = binding.contentLayout;
        mGrayColor = getColor(R.color.gray);


        ((WordSearchApp) getApplication()).getAppComponent().inject(this);

        mLetterBoard.getStreakView().setEnableOverrideStreakLineColor(mPref.grayscale());
        mLetterBoard.getStreakView().setOverrideStreakLineColor(mGrayColor);
        mLetterBoard.setOnLetterSelectionListener(new LetterBoard.OnLetterSelectionListener() {
            @Override
            public void onSelectionBegin(StreakView.StreakLine streakLine, String str) {
                streakLine.setColor(Util.getRandomColorWithAlpha(170));
                mTextSelLayout.setVisibility(View.VISIBLE);
                mTextSelection.setText(str);
            }

            @Override
            public void onSelectionDrag(StreakView.StreakLine streakLine, String str) {
                if (str.isEmpty()) {
                    mTextSelection.setText("...");
                } else {
                    mTextSelection.setText(str);
                }
            }

            @Override
            public void onSelectionEnd(StreakView.StreakLine streakLine, String str) {
                mPresenter.answerWord(str, streakLine, mPref.reverseMatching());
                mTextSelLayout.setVisibility(View.GONE);
                mTextSelection.setText(str);
            }
        });


        mPresenter.setView(this);
        if (getIntent().getExtras() != null) {
            mGameId = getIntent().getExtras().getInt(EXTRA_GAME_ROUND_ID);
            mPresenter.loadGameRound(mGameId);
        }

        if (!mPreferences.showGridLine()) {
            mLetterBoard.getGridLineBackground().setVisibility(View.INVISIBLE);
        } else {
            mLetterBoard.getGridLineBackground().setVisibility(View.VISIBLE);
        }

        mLetterBoard.getStreakView().setSnapToGrid(mPreferences.getSnapToGrid());
        mFinishedText.setVisibility(View.GONE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.resumeGame();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.stopGame();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    private void tryScale() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int boardWidth = mLetterBoard.getWidth();
        int screenWidth = metrics.widthPixels;

        if (mPref.autoScaleGrid() || boardWidth > screenWidth) {
            float scale = (float) screenWidth / (float) boardWidth;
            mLetterBoard.scale(scale, scale);
        }
    }

    @Override
    public void doneLoadingContent() {
        // call tryScale() on the next render frame
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                tryScale();
            }
        });
    }

    @Override
    public void showLoading(boolean enable) {
        if (enable) {
            mLoading.setVisibility(View.VISIBLE);
            mContentLayout.setVisibility(View.GONE);
        } else {
            mLoading.setVisibility(View.GONE);
            mContentLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showLetterGrid(char[][] grid) {
        if (mLetterAdapter == null) {
            mLetterAdapter = new ArrayLetterGridDataAdapter(grid);
            mLetterBoard.setDataAdapter(mLetterAdapter);
        } else {
            mLetterAdapter.setGrid(grid);
        }
    }

    @Override
    public void showDuration(int duration) {
        mTextDuration.setText(DurationFormatter.fromInteger(duration));
    }

    @Override
    public void showUsedWords(List<UsedWordViewModel> usedWords) {
        for (UsedWordViewModel uw : usedWords) {
            mFlowLayout.addView(createUsedWordTextView(uw));
        }
    }

    @Override
    public void showAnsweredWordsCount(int count) {
        mAnsweredTextCount.setText(String.valueOf(count));
    }

    @Override
    public void showWordsCount(int count) {
        mWordsCount.setText(String.valueOf(count));
    }

    @Override
    public void showFinishGame() {
        if(false) {
            Intent intent = new Intent(this, FinishActivity.class);
            intent.putExtra(FinishActivity.EXTRA_GAME_ROUND_ID, mGameId);
            startActivity(intent);
            finish();

            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        }else{
            new AlertDialog.Builder(this).setTitle(R.string.congratulations).setMessage(R.string.win_tip).setPositiveButton(R.string.main_menu, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            }).create().show();
        }



    }

    @Override
    public void setGameAsAlreadyFinished() {
        mLetterBoard.getStreakView().setInteractive(false);
        mFinishedText.setVisibility(View.VISIBLE);
    }

    @Override
    public void wordAnswered(boolean correct, int usedWordId) {
        if (correct) {
            TextView textView = findUsedWordTextViewByUsedWordId(usedWordId);
            if (textView != null) {
                UsedWordViewModel uw = (UsedWordViewModel) textView.getTag();

                if (mPref.grayscale()) {
                    uw.getUsedWord().getAnswerLine().color = mGrayColor;
                }
                textView.setBackgroundColor(uw.getStreakLine().getColor());
                textView.setText(uw.getString());
                textView.setTextColor(Color.WHITE);
                textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

                Animator anim = AnimatorInflater.loadAnimator(this, R.animator.zoom_in_out);
                anim.setTarget(textView);
                anim.start();
            }

            mSoundManager.play(SoundManager.SOUND_CORRECT);
        } else {
            mLetterBoard.popStreakLine();

            mSoundManager.play(SoundManager.SOUND_WRONG);
        }
    }

    //
    private TextView createUsedWordTextView(UsedWordViewModel uw) {
        TextView tv = new TextView(this);
        tv.setPadding(10, 5, 10, 5);
        if (uw.isAnswered()) {
            if (mPref.grayscale()) {
                uw.getUsedWord().getAnswerLine().color = mGrayColor;
            }
            tv.setBackgroundColor(uw.getStreakLine().getColor());
            tv.setText(uw.getString());
            tv.setTextColor(Color.WHITE);
            tv.setPaintFlags(tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            mLetterBoard.addStreakLine(uw.getStreakLine());
        } else {
            String str = uw.getString();
            if (uw.isMystery()) {
                int revealCount = uw.getUsedWord().getRevealCount();
                String uwString = uw.getString();
                str = "";
                for (int i = 0; i < uwString.length(); i++) {
                    if (revealCount > 0) {
                        str += uwString.charAt(i);
                        revealCount--;
                    } else {
                        str += " ?";
                    }
                }
            }
            tv.setText(str);
        }

        tv.setTag(uw);
        return tv;
    }

    private TextView findUsedWordTextViewByUsedWordId(int usedWordId) {
        for (int i = 0; i < mFlowLayout.getChildCount(); i++) {
            TextView tv = (TextView) mFlowLayout.getChildAt(i);
            UsedWordViewModel uw = (UsedWordViewModel) tv.getTag();
            if (uw != null && uw.getId() == usedWordId) {
                return tv;
            }
        }

        return null;
    }
}
