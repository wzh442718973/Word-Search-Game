
package com.refined.stylish.sanhdieu.domain.usecases;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import com.refined.stylish.sanhdieu.domain.data.source.VFusion;

import javax.inject.Inject;

 

public class CWIAdvertisingRound extends KFFile<KFFile.CFGenerator, KFFile.GEProviderMapper> {

    private VFusion mDataSource;

    @Inject
    public CWIAdvertisingRound(VFusion dataSource) {
        mDataSource = dataSource;
    }

    @Override
    protected void execute(CFGenerator params) {
        mDataSource.deleteGameRounds();
        getCallback().onSuccess(new GEProviderMapper());
    }

    public static class GEProviderMapper implements KFFile.GEProviderMapper {
    }
}
