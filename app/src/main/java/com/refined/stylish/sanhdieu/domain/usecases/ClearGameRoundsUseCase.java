package com.refined.stylish.sanhdieu.domain.usecases;

import com.refined.stylish.sanhdieu.domain.data.source.GameRoundDataSource;

import javax.inject.Inject;

/**
 * Created by abdularis on 20/07/17.
 */

public class ClearGameRoundsUseCase extends UseCase<UseCase.Params, UseCase.Result> {

    private GameRoundDataSource mDataSource;

    @Inject
    public ClearGameRoundsUseCase(GameRoundDataSource dataSource) {
        mDataSource = dataSource;
    }

    @Override
    protected void execute(Params params) {
        mDataSource.deleteGameRounds();
        getCallback().onSuccess(new Result());
    }

    public static class Result implements UseCase.Result {
    }
}
