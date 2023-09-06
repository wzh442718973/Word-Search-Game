
package com.refined.stylish.sanhdieu.domain.usecases;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import com.refined.stylish.sanhdieu.domain.data.source.VFusion;

import javax.inject.Inject;

 

public class YJGSecurityPath extends KFFile<YJGSecurityPath.CFGenerator, YJGSecurityPath.GEProviderMapper> {

    private VFusion mDataSource;

    @Inject
    public YJGSecurityPath(VFusion dataSource) {
        mDataSource = dataSource;
    }

    @Override
    protected void execute(CFGenerator params) {
        mDataSource.saveGameRoundDuration(params.gameRoundId, params.duration);
        getCallback().onSuccess(new GEProviderMapper());
    }

    public static class CFGenerator implements KFFile.CFGenerator {
        public int gameRoundId;
        public int duration;

        public CFGenerator(int gameRoundId, int duration) {
            this.gameRoundId = gameRoundId;
            this.duration = duration;
        }
    }

    public static class GEProviderMapper implements KFFile.GEProviderMapper {}
}
