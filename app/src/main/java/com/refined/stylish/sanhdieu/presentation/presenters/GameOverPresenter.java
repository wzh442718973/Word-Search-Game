package com.refined.stylish.sanhdieu.presentation.presenters;

import com.refined.stylish.sanhdieu.domain.usecases.DeleteGameRoundUseCase;
import com.refined.stylish.sanhdieu.domain.usecases.GetGameRoundStatUseCase;
import com.refined.stylish.sanhdieu.domain.usecases.UseCase;
import com.refined.stylish.sanhdieu.domain.usecases.UseCaseExecutor;
import com.refined.stylish.sanhdieu.presentation.views.GameOverView;

import javax.inject.Inject;

/**
 * Created by abdularis on 23/07/17.
 */

public class GameOverPresenter {

    private GameOverView mView;
    private UseCaseExecutor mCaseExecutor;
    private GetGameRoundStatUseCase mGameRoundStatUseCase;
    private DeleteGameRoundUseCase mDeleteGameRoundUseCase;

    @Inject
    public GameOverPresenter(UseCaseExecutor caseExecutor,
                             GetGameRoundStatUseCase gameRoundStatUseCase, DeleteGameRoundUseCase deleteGameRoundUseCase) {
        mCaseExecutor = caseExecutor;
        mGameRoundStatUseCase = gameRoundStatUseCase;
        mDeleteGameRoundUseCase = deleteGameRoundUseCase;
    }

    public void setView(GameOverView view) {
        mView = view;
    }

    public void loadData(int gid) {
        mGameRoundStatUseCase.setParams(new GetGameRoundStatUseCase.Params(gid));
        mCaseExecutor.execute(mGameRoundStatUseCase, new UseCase.Callback<GetGameRoundStatUseCase.Result>() {
            @Override
            public void onSuccess(GetGameRoundStatUseCase.Result result) {
                mView.showGameStat(result.gameRoundStat);
            }

            @Override
            public void onFailed(String errMsg) {}
        });
    }

    public void deleteGameRound(int gid) {
        mDeleteGameRoundUseCase.setParams(new DeleteGameRoundUseCase.Params(gid));
        mCaseExecutor.execute(mDeleteGameRoundUseCase, new UseCase.Callback<DeleteGameRoundUseCase.Result>() {
            @Override
            public void onSuccess(DeleteGameRoundUseCase.Result result) {}

            @Override
            public void onFailed(String errMsg) {}
        });
    }

}
