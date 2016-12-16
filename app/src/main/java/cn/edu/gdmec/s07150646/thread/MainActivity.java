package cn.edu.gdmec.s07150646.thread;

import android.graphics.BitmapFactory;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {
  private TextView tv1; private int seconds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1= (TextView) findViewById(R.id.tv1);
        Date theLastDay=new Date(117,5,23);
        Date toDay=new Date();
        seconds=(int)(theLastDay.getTime()-toDay.getTime())/1000;
    }
    public void anr(View v){
        for(int i=0;i<10000;i++){
//            BitmapFactory.decodeResource(getResources(),R.drawable.android);
        }

    }
    public void thread(View v){
        class ThreadSample extends Thread{
            Random rm;
            public ThreadSample(String tname){
                super(tname);
                rm=new Random();
            }
            public void run(){
                for(int i=0;i<10;i++){
                    System.out.println(i+""+getName());




                }
                System.out.println("完成");
            }
        }
        ThreadSample thread1=new ThreadSample("线程1");
        thread1.start();
        ThreadSample thread2=new ThreadSample("线程2");
        thread2.start();
    }
    public void time(View v){
        class MyThread extends TimerTask{
                Random rm;
            String name;
            public MyThread(String tname){
                this.name=tname;
                rm=new Random();
            }
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    System.out.println(i+name);
                }
                System.out.println("完成");
            }
            Timer timer1=new Timer();
            Timer timer2=new Timer();
           MyThread thread1=new MyThread("线程一");
            MyThread thread2=new MyThread("线程二");

        }
    }
    public void hander(View v){
        class MyTask extends TimerTask{
            int countdown;
            double achi=1,ach2=1;
            public MyTask(int seconds){
                this.countdown=seconds;
            }
            @Override
            public void run() {
                Message msg=Message.obtain();
                msg.what=1;
                msg.arg1=countdown--;
                achi=achi*1.01;
                ach2=ach2*1.02;
                Bundle bundle=new Bundle();
                bundle.putString("attach","nuisance"+ach2);
                msg.setData(bundle);
                //myHandler.sendMessage(msg);
            }
        }
    }
    public void sayn(View v){

    }
}
