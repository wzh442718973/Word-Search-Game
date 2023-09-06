
package com.refined.stylish.sanhdieu.presentation.views;
import android.widget.TextView;


import android.widget.ImageView;


import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import com.refined.stylish.sanhdieu.presentation.model.EIndex;

import java.util.List;

 

public interface CProcessorPackageView {

    void doneLoadingContent();

    void showLoading(boolean enable);

    void showLetterGrid(char grid[][]);

    void showDuration(int duration);

    void showUsedWords(List<EIndex> usedWords);

    void showAnsweredWordsCount(int count);

    void showWordsCount(int count);

    void showFinishGame();

    void setGameAsAlreadyFinished();

    void wordAnswered(boolean correct, int usedWordId);

}
