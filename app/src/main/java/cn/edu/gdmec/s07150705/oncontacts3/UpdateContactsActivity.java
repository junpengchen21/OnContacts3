package cn.edu.gdmec.s07150705.oncontacts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public class UpdateContactsActivity extends AppCompatActivity{
    private EditText et1,et2,et3,et4,et5;
    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        et1 = (EditText)findViewById(R.id.name);
        et2 = (EditText)findViewById(R.id.mobile);
        et3 = (EditText)findViewById(R.id.danwei);
        et4 = (EditText)findViewById(R.id.qq);
        et5 = (EditText)findViewById(R.id.address);
        Bundle localBundle = getIntent().getExtras();
        int id =localBundle.getInt("user_ID");
        ContactsTable ct = new ContactsTable(this);
        user = ct.getUserByID(id);
        et1.setText(user.getName());
        et2.setText(user.getMobile());
        et3.setText(user.getDanwei());
        et4.setText(user.getQq());
        et5.setText(user.getAddress());

    }
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0,1,0,"保存");
        menu.add(0,2,0,"返回");
        return  super.onCreateOptionsMenu(menu);
    }
    public  boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case 1 :
                if(!et1.getText().toString().trim().equals("")){
                    user.setName(et1.getText().toString());
                    user.setMobile(et2.getText().toString());
                    user.setDanwei(et3.getText().toString());
                    user.setQq(et4.getText().toString());
                    user.setAddress(et5.getText().toString());
                    ContactsTable ct = new ContactsTable(this);
                    if(ct.updateUser(user)){
                        Toast.makeText(this,"修改成功",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(this,"修改失败",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(this,"数据不能为空!",Toast.LENGTH_LONG).show();
                }
                break;
            case  2:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
