package cn.edu.gdmec.s07150705.oncontacts;

import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Administrator on 2016/11/7 0007.
 */
public class FindDialog extends Dialog {
    private Context l_context;
    public  FindDialog(Context context){
        super(context);
        l_context =context;
    }
protected  void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.find);
    setTitle("查询联系人");
    final Button find=(Button)findViewById(R.id.find);
    Button cancel =(Button)findViewById(R.id.cancel);
    find.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            EditText value = (EditText) findViewById(R.id.value);
            ContactsTable ct =new ContactsTable(l_context);
            User[] users =ct.findUserByKey(value.getText().toString());
            for(int i =0 ;i<users.length;i++){
                System.out.println("姓名:"+users[i].getName()+",电话:"+users[i].getMobile());
            }
            ((MainActivity)l_context).setUsers(users);
            ((MainActivity)l_context).getListViewAdapter().notifyDataSetChanged();
            ((MainActivity)l_context).setSelectItem(0);
            dismiss();
        }
    });
    cancel.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            dismiss();
        }
    });
}

}
