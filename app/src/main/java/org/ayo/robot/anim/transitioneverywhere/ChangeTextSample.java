/*
 * Copyright (C) 2016 Andrey Kulikov (andkulikov@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ayo.robot.anim.transitioneverywhere;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.ayo.animate.transition.ChangeText;
import org.ayo.animate.transition.TransitionManager;
import org.ayo.robot.anim.R;


/**
 * Created by Andrey Kulikov on 17/04/16.
 */
public class ChangeTextSample extends Fragment {

    public static final String TEXT_1 = "Hi, i am text. Tap on me!";
    public static final String TEXT_2 = "Thanks! Another tap?";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_text, container, false);

        final ViewGroup transitionsContainer = (ViewGroup) view.findViewById(R.id.transitions_container);
        final TextView textView = (TextView) transitionsContainer.findViewById(R.id.text1);

        textView.setText(TEXT_1);
        textView.setOnClickListener(new View.OnClickListener() {

            boolean mSecondText;

            @Override
            public void onClick(View v) {
                mSecondText = !mSecondText;
                TransitionManager.beginDelayedTransition(transitionsContainer,
                    new ChangeText().setChangeBehavior(ChangeText.CHANGE_BEHAVIOR_OUT_IN));
                textView.setText(mSecondText ? TEXT_2 : TEXT_1);
            }

        });

        return view;
    }
}
