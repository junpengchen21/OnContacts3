package cn.edu.gdmec.s07150705.oncontacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class AddcontactsActivity extends AppCompatActivity{
    private EditText et1,et2,et3,et4,et5;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        setTitle("添加联系人");
        et1 = (EditText)findViewById(R.id.name);
        et2 = (EditText)findViewById(R.id.mobile);
        et3 = (EditText)findViewById(R.id.danwei);
        et4 = (EditText)findViewById(R.id.qq);
        et5 = (EditText)findViewById(R.id.address);
    }
    public boolean onCreateOptionsMenu(Menu menu){
      menu.add(Menu.NONE,1,Menu.NONE,"保存");
        menu.add(Menu.NONE,2,Menu.NONE,"返回");
        return  super.onCreateOptionsMenu(menu);
    }
public  boolean onOptionsItemSelected(MenuItem item){
    switch (item.getItemId()){
        case  1:
            if(!et1.getText().toString().equals("")){
                User user = new User();
                user.setName(et1.getText().toString());
                user.setMobile(et2.getText().toString());
                user.setDanwei(et3.getText().toString());
                user.setQq(et4.getText().toString());
                user.setAddress(et5.getText().toString());
                ContactsTable ct =new ContactsTable(AddcontactsActivity.this);
                if(ct.addData(user)){
                    Toast.makeText(AddcontactsActivity.this,"添加成功",Toast.LENGTH_LONG).show();
                    finish();
                }else{
                    Toast.makeText(AddcontactsActivity.this,"添加失败",Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(AddcontactsActivity.this,"请输入数据",Toast.LENGTH_LONG).show();

            }
            break;
    }
    return super.onOptionsItemSelected(item);
}

}
