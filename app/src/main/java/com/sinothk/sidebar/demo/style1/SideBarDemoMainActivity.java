package com.sinothk.sidebar.demo.style1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sinothk.sidebar.demo.R;
import com.sinothk.widget.sidebar.style1.WaveSideBar;

import java.util.ArrayList;

public class SideBarDemoMainActivity extends AppCompatActivity {
    private RecyclerView rvContacts;
    private WaveSideBar sideBar;

    private ArrayList<Contact> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    private void initView() {
        setContentView(R.layout.side_bar_activity_main);
        rvContacts = (RecyclerView) findViewById(R.id.rv_contacts);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));

        contacts.addAll(Contact.getChineseContacts());
        rvContacts.setAdapter(new ContactsAdapter(contacts, R.layout.side_bar_item_contacts));

        sideBar = (WaveSideBar) findViewById(R.id.side_bar);
        sideBar.setIndexItems("A", "B", "D", "F", "H", "#");
        sideBar.setPosition(WaveSideBar.POSITION_RIGHT);
        sideBar.setOnSelectIndexItemListener(new WaveSideBar.OnSelectIndexItemListener() {
            @Override
            public void onSelectIndexItem(String index) {
                for (int i = 0; i < contacts.size(); i++) {
                    if (contacts.get(i).getIndex().equals(index)) {
                        ((LinearLayoutManager) rvContacts.getLayoutManager()).scrollToPositionWithOffset(i, 0);
                        return;
                    }else{
                    }
                }
            }
        });
    }

}
