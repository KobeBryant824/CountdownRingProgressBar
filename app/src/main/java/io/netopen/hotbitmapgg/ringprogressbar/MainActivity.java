package io.netopen.hotbitmapgg.ringprogressbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

public class MainActivity extends AppCompatActivity {

    private RingProgressBar mRingProgressBar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRingProgressBar1 = (RingProgressBar) findViewById(R.id.progress_bar_1);

        mRingProgressBar1.start();

        mRingProgressBar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRingProgressBar1.start();
            }
        });

        mRingProgressBar1.setOnProgressListener(new RingProgressBar.OnProgressListener() {
            @Override
            public void progresToWarn() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "最后三秒啦", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void progressToComplete() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "绘制完成啦", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
