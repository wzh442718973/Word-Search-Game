
package com.refined.stylish.sanhdieu.domain.data.source;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import com.refined.stylish.sanhdieu.domain.model.IInit;

import java.util.List;

 

public interface RFLibcocosdjsUsage {

    interface Callback {

        void onWordsLoaded(List<IInit> words);

    }

    void getWords(Callback callback);

}
