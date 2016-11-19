package cn.edu.gdmec.s07150705.oncontacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class ContactsMessageActivity extends AppCompatActivity {
    private TextView tv1,tv2,tv3,tv4,tv5;
    private  User user;
    protected  void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
        setContentView(R.layout.message);
        setTitle("联系人信息");
        tv1= (TextView) findViewById(R.id.name);
        tv2= (TextView) findViewById(R.id.mobile);
        tv3= (TextView) findViewById(R.id.danwei);
        tv4= (TextView) findViewById(R.id.qq);
        tv5= (TextView) findViewById(R.id.address);
        Bundle localBundle = getIntent().getExtras();
        int id = localBundle.getInt("user_ID");
        ContactsTable ct = new ContactsTable(this);
        user =ct.getUserByID(id);
        tv1.setText("姓名:"+user.getName());
        tv2.setText("电话:"+user.getMobile());
        tv3.setText("qq:"+user.getDanwei());
        tv4.setText("单位:"+user.getQq());
        tv5.setText("地址:"+user.getAddress());
    }

    public  boolean onCreateOptionsMenu(Menu menu){
        menu.add(0,1,0,"返回");
        return  super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
             switch (item.getItemId()){
                 case  1 :
                     finish();
                     break;

             }
        return super.onOptionsItemSelected(item);
    }
}
