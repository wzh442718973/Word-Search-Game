package com.refined.stylish.sanhdieu.domain.usecases;


import com.refined.stylish.sanhdieu.commons.Util;
import com.refined.stylish.sanhdieu.commons.generator.StringListGridGenerator;
import com.refined.stylish.sanhdieu.domain.data.mapper.GameRoundMapper;
import com.refined.stylish.sanhdieu.domain.data.source.GameRoundDataSource;
import com.refined.stylish.sanhdieu.domain.data.source.WordDataSource;
import com.refined.stylish.sanhdieu.domain.model.GameRound;
import com.refined.stylish.sanhdieu.domain.model.Grid;
import com.refined.stylish.sanhdieu.domain.model.UsedWord;
import com.refined.stylish.sanhdieu.domain.model.Word;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

/**
 * Created by abdularis on 20/07/17.
 */

public class BuildGameRoundUseCase extends UseCase<BuildGameRoundUseCase.Params, BuildGameRoundUseCase.Result> {

    private GameRoundDataSource mGameRoundDataSource;
    private WordDataSource mWordDataSource;

    @Inject
    public BuildGameRoundUseCase(GameRoundDataSource gameRoundDataSource, WordDataSource wordDataSource) {
        mGameRoundDataSource = gameRoundDataSource;
        mWordDataSource = wordDataSource;
    }

    @Override
    protected void execute(Params params) {
        GameRound gameRound = createNewGameRound(params.rowCount, params.colCount, params.name);
        getCallback().onSuccess(new Result(gameRound));
    }

    private GameRound createNewGameRound(final int rowCount, final int colCount, final String name) {
        final GameRound gameRound = new GameRound();

        mWordDataSource.getWords(new WordDataSource.Callback() {
            @Override
            public void onWordsLoaded(List<Word> words) {
                Util.randomizeList(words);

                Grid grid = new Grid(rowCount, colCount);
                int maxCharCount = Math.min(rowCount, colCount);
                List<String> usedStrings =
                        new StringListGridGenerator().setGrid(getStringListFromWord(words, 100, maxCharCount), grid.getArray());

                gameRound.addUsedWords(buildUsedWordFromString(usedStrings));
                gameRound.setGrid(grid);
                if (name == null || name.isEmpty()) {
                    String name = "Puzzle " +
                            new SimpleDateFormat("HH.mm.ss").format(new Date(System.currentTimeMillis()));
                    gameRound.getInfo().setName(name);
                }
                else {
                    gameRound.getInfo().setName(name);
                }

                mGameRoundDataSource.saveGameRound(new GameRoundMapper().revMap(gameRound));
            }
        });

        return gameRound;
    }

    private List<UsedWord> buildUsedWordFromString(List<String> strings) {
        int mysteryWordCount = Util.getRandomIntRange(strings.size() / 2, strings.size());
        List<UsedWord> usedWords = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            String str = strings.get(i);

            UsedWord uw = new UsedWord();
            uw.setString(str);
            uw.setAnswered(false);
            if (mysteryWordCount > 0) {
                uw.setMystery(true);
                uw.setRevealCount(Util.getRandomIntRange(0, str.length() - 1));
                mysteryWordCount--;
            }

            usedWords.add(uw);
        }

        Util.randomizeList(usedWords);
        return usedWords;
    }

    private List<String> getStringListFromWord(List<Word> words, int count, int maxCharCount) {
        count = Math.min(count, words.size());

        List<String> stringList = new ArrayList<>();
        String temp;
        for (int i = 0; i < words.size(); i++) {
            if (stringList.size() >= count) break;

            temp = words.get(i).getString();
            if (temp.length() <= maxCharCount) {
                stringList.add(temp);
            }
        }

        return stringList;
    }

    public static class Params implements UseCase.Params {
        public int rowCount;
        public int colCount;
        public String name;

        public Params(int rowCount, int colCount, String name) {
            this.rowCount = rowCount;
            this.colCount = colCount;
            this.name = name;
        }
    }

    public static class Result implements UseCase.Result {
        public GameRound gameRound;

        public Result(GameRound gameRound) {
            this.gameRound = gameRound;
        }
    }

}
