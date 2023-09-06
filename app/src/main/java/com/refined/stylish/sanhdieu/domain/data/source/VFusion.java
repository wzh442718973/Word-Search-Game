
package com.refined.stylish.sanhdieu.domain.data.source;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import com.refined.stylish.sanhdieu.domain.data.entity.YKGradlew;
import com.refined.stylish.sanhdieu.domain.model.OVNNameLauncher;
import com.refined.stylish.sanhdieu.domain.model.BQMain;
import com.refined.stylish.sanhdieu.domain.model.TFCaseField;

import java.util.List;

 

public interface VFusion {

    interface IFusionFullscreen {

        void onLoaded(YKGradlew gameRound);

    }

    interface WPoolMedia {

        void onLoaded(List<OVNNameLauncher.HQAfter> infoList);
    }

    interface FREWordArray {

        void onLoaded(BQMain stat);

    }

    void getGameRound(int gid, IFusionFullscreen callback);

    void getGameRoundInfos(WPoolMedia callback);

    void getGameRoundStat(int gid, FREWordArray callback);

    void saveGameRound(YKGradlew gameRound);

    void deleteGameRound(int gid);

    void deleteGameRounds();

    void saveGameRoundDuration(int gid, int newDuration);

    void markWordAsAnswered(TFCaseField usedWord);
}
