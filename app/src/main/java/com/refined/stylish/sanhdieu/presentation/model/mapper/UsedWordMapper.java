package com.refined.stylish.sanhdieu.presentation.model.mapper;

import com.refined.stylish.sanhdieu.commons.Mapper;
import com.refined.stylish.sanhdieu.domain.model.UsedWord;
import com.refined.stylish.sanhdieu.presentation.model.UsedWordViewModel;

/**
 * Created by abdularis on 18/07/17.
 */

public class UsedWordMapper extends Mapper<UsedWord, UsedWordViewModel> {
    @Override
    public UsedWordViewModel map(UsedWord obj) {
        return new UsedWordViewModel(obj);
    }

    @Override
    public UsedWord revMap(UsedWordViewModel obj) {
        return obj.getUsedWord();
    }
}
