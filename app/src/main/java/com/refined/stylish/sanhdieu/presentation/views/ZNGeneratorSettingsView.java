
package com.refined.stylish.sanhdieu.presentation.views;
import android.widget.TextView;


import android.widget.ImageView;


import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import com.refined.stylish.sanhdieu.domain.model.OVNNameLauncher;

import java.util.List;

 

public interface ZNGeneratorSettingsView {

    void setNewGameLoading(boolean enable);

    void showGameInfoList(List<OVNNameLauncher.HQAfter> infoList);

    void showNewlyCreatedGameRound(OVNNameLauncher gameRound);

    void showGameRound(int gid);

    void clearInfoList();

    void deleteInfo(OVNNameLauncher.HQAfter info);

}
