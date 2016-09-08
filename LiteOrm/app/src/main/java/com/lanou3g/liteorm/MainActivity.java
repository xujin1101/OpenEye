package com.lanou3g.liteorm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.litesuits.orm.LiteOrm;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private List<Person> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LiteOrm liteOrm = LiteOrm.newCascadeInstance(this,"My.db");
        Person person = new Person(0,"张三",20);
        //增
        liteOrm.insert(person);
        //增加集合
        data = new ArrayList<>();
        for (int i = 0; i <50 ; i++) {
            Person person1 = new Person(i,"姓名"+i,20+i);
            data.add(person1);
        }
        Person person_new= new Person(10,"李四",100);
        liteOrm.insert(person_new);
        liteOrm.save(data);
       liteOrm.delete(person_new);
     //   liteOrm.deleteAll(Person.class);
        List<Person> list = liteOrm.query(Person.class);
        for (Person person1 : list) {
            Log.d("MainActivity", person1.getName());
        }

    }
}
