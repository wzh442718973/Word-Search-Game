
package com.refined.stylish.sanhdieu.domain.usecases;
import java.util.HashMap;




import com.refined.stylish.sanhdieu.commons.Util;
import com.refined.stylish.sanhdieu.commons.generator.XVEntryWifi;
import com.refined.stylish.sanhdieu.domain.data.mapper.UProxy;
import com.refined.stylish.sanhdieu.domain.data.source.VFusion;
import com.refined.stylish.sanhdieu.domain.data.source.RFLibcocosdjsUsage;
import com.refined.stylish.sanhdieu.domain.model.OVNNameLauncher;
import com.refined.stylish.sanhdieu.domain.model.FZIAlarmBoard;
import com.refined.stylish.sanhdieu.domain.model.TFCaseField;
import com.refined.stylish.sanhdieu.domain.model.IInit;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

 

public class HTelephony extends KFFile<HTelephony.CFGenerator, HTelephony.GEProviderMapper> {

    private VFusion mGameRoundDataSource;
    private RFLibcocosdjsUsage mWordDataSource;

    @Inject
    public HTelephony(VFusion gameRoundDataSource, RFLibcocosdjsUsage wordDataSource) {
        mGameRoundDataSource = gameRoundDataSource;
        mWordDataSource = wordDataSource;
    }

    @Override
    protected void execute(CFGenerator params) {
        OVNNameLauncher gameRound = createNewGameRound(params.rowCount, params.colCount, params.name);
        getCallback().onSuccess(new GEProviderMapper(gameRound));
    }

    private OVNNameLauncher createNewGameRound(final int rowCount, final int colCount, final String name) {
        final OVNNameLauncher gameRound = new OVNNameLauncher();

        mWordDataSource.getWords(new RFLibcocosdjsUsage.Callback() {
            @Override
            public void onWordsLoaded(List<IInit> words) {
                Util.randomizeList(words);

                FZIAlarmBoard grid = new FZIAlarmBoard(rowCount, colCount);
                int maxCharCount = Math.min(rowCount, colCount);
                List<String> usedStrings =
                        new XVEntryWifi().setGrid(getStringListFromWord(words, 100, maxCharCount), grid.getArray());

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

                mGameRoundDataSource.saveGameRound(new UProxy().revMap(gameRound));
            }
        });

        return gameRound;
    }

    private List<TFCaseField> buildUsedWordFromString(List<String> strings) {
        int mysteryWordCount = Util.getRandomIntRange(strings.size() / 2, strings.size());
        List<TFCaseField> usedWords = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            String str = strings.get(i);

            TFCaseField uw = new TFCaseField();
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

    private List<String> getStringListFromWord(List<IInit> words, int count, int maxCharCount) {
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

    public static class CFGenerator implements KFFile.CFGenerator {
        public int rowCount;
        public int colCount;
        public String name;

        public CFGenerator(int rowCount, int colCount, String name) {
            this.rowCount = rowCount;
            this.colCount = colCount;
            this.name = name;
        }
    }

    public static class GEProviderMapper implements KFFile.GEProviderMapper {
        public OVNNameLauncher gameRound;

        public GEProviderMapper(OVNNameLauncher gameRound) {
            this.gameRound = gameRound;
        }
    }

}
