package com.xebia.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by flibam on 4/16/15.
 */
public class MowerTestConstructor {

    private Mower mower;

    @Test(expected = IllegalStateException.class)
    public void testStateException() {
         mower = new Mower(1,1,'N');
    }

}