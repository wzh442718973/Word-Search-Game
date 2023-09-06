
package com.refined.stylish.sanhdieu.domain.usecases;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import com.refined.stylish.sanhdieu.commons.Util;
import com.refined.stylish.sanhdieu.domain.data.source.VFusion;
import com.refined.stylish.sanhdieu.domain.model.TFCaseField;

import java.util.List;

import javax.inject.Inject;

 

public class KIFDimens extends KFFile<KIFDimens.CFGenerator, KIFDimens.GEProviderMapper> {

    private VFusion mDataSource;

    @Inject
    public KIFDimens(VFusion dataSource) {
        mDataSource = dataSource;
    }

    @Override
    protected void execute(CFGenerator params) {
        boolean correct = false;
        TFCaseField correctWord = null;

        String answerStr = params.mString;
        String answerStrRev = Util.getReverseString(answerStr);
        for (TFCaseField word : params.mUsedWords) {

            if (word.isAnswered()) continue;

            String wordStr = word.getString();
            if (wordStr.equalsIgnoreCase( answerStr ) ||
                    (wordStr.equalsIgnoreCase( answerStrRev ) && params.reverseMatching)) {

                correct = true;
                correctWord = word;

                correctWord.setAnswered(true);
                correctWord.setAnswerLine(params.mLine);
                break;
            }
        }

        if (correct) {
            mDataSource.markWordAsAnswered(correctWord);
        }

        getCallback().onSuccess(new GEProviderMapper(correct, correctWord));
    }

    public static class CFGenerator implements KFFile.CFGenerator {
        public String mString;
        public TFCaseField.GEBilling mLine;
        public List<TFCaseField> mUsedWords;
        public boolean reverseMatching;

        public CFGenerator(String string, TFCaseField.GEBilling line, List<TFCaseField> usedWords, boolean reverseMatching) {
            mString = string;
            mLine = line;
            mUsedWords = usedWords;
            this.reverseMatching = reverseMatching;
        }
    }

    public static class GEProviderMapper implements KFFile.GEProviderMapper {
        public boolean mCorrect;
        public TFCaseField mUsedWord;

        public GEProviderMapper(boolean correct, TFCaseField usedWord) {
            mCorrect = correct;
            mUsedWord = usedWord;
        }
    }
}
