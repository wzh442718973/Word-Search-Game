
package com.refined.stylish.sanhdieu.domain.usecases;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import com.refined.stylish.sanhdieu.domain.data.source.VFusion;
import com.refined.stylish.sanhdieu.domain.model.BQMain;

import javax.inject.Inject;

 

public class MCompat
        extends KFFile<MCompat.CFGenerator, MCompat.GEProviderMapper> {

    private VFusion mDataSource;

    @Inject
    public MCompat(VFusion dataSource) {
        mDataSource = dataSource;
    }

    @Override
    protected void execute(CFGenerator params) {
        mDataSource.getGameRoundStat(params.gameRoundId, new VFusion.FREWordArray() {
            @Override
            public void onLoaded(BQMain stat) {
                getCallback().onSuccess(new GEProviderMapper(stat));
            }
        });
    }

    public static class CFGenerator implements KFFile.CFGenerator {
        public int gameRoundId;

        public CFGenerator(int gameRoundId) {
            this.gameRoundId = gameRoundId;
        }
    }

    public static class GEProviderMapper implements KFFile.GEProviderMapper {
        public BQMain gameRoundStat;

        public GEProviderMapper(BQMain gameRoundStat) {
            this.gameRoundStat = gameRoundStat;
        }
    }
}
