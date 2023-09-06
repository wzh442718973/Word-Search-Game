
package com.refined.stylish.sanhdieu.domain.usecases;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import com.refined.stylish.sanhdieu.domain.data.source.VFusion;
import com.refined.stylish.sanhdieu.domain.model.OVNNameLauncher;

import java.util.List;

import javax.inject.Inject;

 

public class QJATelephonyCorrect extends KFFile<QJATelephonyCorrect.CFGenerator, QJATelephonyCorrect.GEProviderMapper> {

    private VFusion mDataSource;

    @Inject
    public QJATelephonyCorrect(VFusion dataSource) {
        mDataSource = dataSource;
    }

    @Override
    protected void execute(CFGenerator params) {
        mDataSource.getGameRoundInfos(new VFusion.WPoolMedia() {
            @Override
            public void onLoaded(List<OVNNameLauncher.HQAfter> infoList) {
                getCallback().onSuccess(new GEProviderMapper(infoList));
            }
        });
    }

    public static class CFGenerator implements KFFile.CFGenerator {
    }

    public static class GEProviderMapper implements KFFile.GEProviderMapper {
        public List<OVNNameLauncher.HQAfter> infoList;

        public GEProviderMapper(List<OVNNameLauncher.HQAfter> infoList) {
            this.infoList = infoList;
        }
    }

}
