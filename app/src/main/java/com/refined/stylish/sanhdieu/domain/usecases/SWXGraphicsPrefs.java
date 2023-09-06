
package com.refined.stylish.sanhdieu.domain.usecases;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import com.refined.stylish.sanhdieu.domain.data.entity.YKGradlew;
import com.refined.stylish.sanhdieu.domain.data.mapper.UProxy;
import com.refined.stylish.sanhdieu.domain.data.source.VFusion;
import com.refined.stylish.sanhdieu.domain.model.OVNNameLauncher;

import javax.inject.Inject;

 

public class SWXGraphicsPrefs extends KFFile<SWXGraphicsPrefs.CFGenerator, SWXGraphicsPrefs.GEProviderMapper> {

    private VFusion mGameRoundDataSource;

    @Inject
    public SWXGraphicsPrefs(VFusion gameRoundDataSource) {
        mGameRoundDataSource = gameRoundDataSource;
    }

    @Override
    protected void execute(final CFGenerator params) {
        mGameRoundDataSource.getGameRound(params.gameRoundId, new VFusion.IFusionFullscreen() {
            @Override
            public void onLoaded(YKGradlew gameRoundEnt) {
                OVNNameLauncher gameRound = new UProxy().map(gameRoundEnt);
                getCallback().onSuccess(new GEProviderMapper(gameRound));
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
        public OVNNameLauncher gameRound;

        public GEProviderMapper(OVNNameLauncher gameRound) {
            this.gameRound = gameRound;
        }
    }

}
