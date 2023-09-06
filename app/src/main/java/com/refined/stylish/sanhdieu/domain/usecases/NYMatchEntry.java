
package com.refined.stylish.sanhdieu.domain.usecases;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



 

public interface NYMatchEntry {

    <P extends KFFile.CFGenerator, O extends KFFile.GEProviderMapper>
    void execute(KFFile<P, O> useCase, KFFile.Callback<O> cb);

}
