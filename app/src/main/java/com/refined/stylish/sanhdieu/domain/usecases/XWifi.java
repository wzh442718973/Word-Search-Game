
package com.refined.stylish.sanhdieu.domain.usecases;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import com.refined.stylish.sanhdieu.domain.data.source.VFusion;

import javax.inject.Inject;

 

public class XWifi extends KFFile<XWifi.CFGenerator, XWifi.GEProviderMapper> {

    private VFusion mDataSource;

    @Inject
    public XWifi(VFusion dataSource) {
        mDataSource = dataSource;
    }

    @Override
    protected void execute(CFGenerator params) {
        mDataSource.deleteGameRound(params.gameRoundId);
        getCallback().onSuccess(new GEProviderMapper());
    }

    public static class CFGenerator implements KFFile.CFGenerator {
        public int gameRoundId;

        public CFGenerator(int gameRoundId) {
            this.gameRoundId = gameRoundId;
        }
    }

    public static class GEProviderMapper implements KFFile.GEProviderMapper {}
}
