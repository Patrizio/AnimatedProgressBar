/*
    Copyright (c) 2014, Athanasios Karpouzis (http://droid-coder.com)  All rights reserved.
    Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
    1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
    2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
    3. Neither the name of the copyright holder nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
    THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package com.droidcoder.androidlibs.animatedprogressbar.sampleapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;

import com.droidcoder.androidlibs.animatedprogressbar.animatedprogressbar.AnimatedProgressBar;

import java.util.ArrayList;
import java.util.List;


public class SampleActivity extends ActionBarActivity {

    private List<AnimatedProgressBar> animatedProgressBarList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);


        animatedProgressBarList = new ArrayList<AnimatedProgressBar>();

        ViewGroup viewGroup = (ViewGroup)getWindow().getDecorView();
        walkOnViews(viewGroup);

        findViewById(R.id.bnt_start).setOnClickListener(new OnStartClick());
        findViewById(R.id.bnt_stop).setOnClickListener(new OnStoptClick());
        findViewById(R.id.bnt_reset).setOnClickListener(new OnResetClick());


    }


    private class OnStartClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            for(AnimatedProgressBar animatedProgressBar : animatedProgressBarList){
                animatedProgressBar.startDefaultAnimation();
            }
        }
    }

    private class OnStoptClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            for(AnimatedProgressBar animatedProgressBar : animatedProgressBarList){
                animatedProgressBar.stopDefaultAnimation();
            }
        }
    }

    private class OnResetClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            for(AnimatedProgressBar animatedProgressBar : animatedProgressBarList){
                animatedProgressBar.setProgress(0);
                animatedProgressBar.setSecondaryProgress(0);
            }
        }
    }


    private void walkOnViews(ViewGroup viewGroup){
        for (int i = 0; i < viewGroup.getChildCount(); i++){
            View view = viewGroup.getChildAt(i);
            if(view instanceof ViewGroup){
                walkOnViews((ViewGroup) view);
            }else if(view instanceof AnimatedProgressBar){
                animatedProgressBarList.add((AnimatedProgressBar)view);
            }
        }
    }



}
