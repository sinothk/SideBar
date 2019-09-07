# 引入
 ## Step 1. Add the JitPack repository to your build file

    allprojects {
      repositories {
        ...
        maven { url 'https://jitpack.io' }
      }
    }
 ## Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.sinothk:SideBar:2.19.0907'
	}
	}

# 使用
 ## 1. XML

	  <RelativeLayout
		android:layout_width="match_parent"
		android:layout_height="match_parent">
		<android.support.v7.widget.RecyclerView
		    android:id="@+id/rv_contacts"
		    android:layout_width="match_parent"
		    android:layout_height="match_parent" />
		<com.sinothk.widget.sidebar.style1.SideBar
		    android:id="@+id/sideBar"
		    android:layout_width="match_parent"
		    android:layout_height="match_parent"
		    android:layout_alignParentEnd="true"
		    app:sidebar_text_color="#8D6E63"
		    app:sidebar_text_size="13sp" />
	    </RelativeLayout>
  
 ## 2. java
  
        contacts.addAll(Contact.getChineseContacts());
        rvContacts.setAdapter(new ContactsAdapter(contacts, R.layout.side_bar_item_contacts));

        SideBar sideBar = (SideBar) findViewById(R.id.sideBar);
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String index) {

                for (int i = 0; i < contacts.size(); i++) {
                    if (contacts.get(i).getIndex().equals(index)) {
                        ((LinearLayoutManager) rvContacts.getLayoutManager()).scrollToPositionWithOffset(i, 0);
                        return;
                    } else {
                    }
                }
            }
        });
        
 ## 3. Adapter

      public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {

      private List<Contact> contacts;
      private int layoutId;

      public ContactsAdapter(List<Contact> contacts, int layoutId) {
          this.contacts = contacts;
          this.layoutId = layoutId;
      }

      @Override
      public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
          LayoutInflater inflater = LayoutInflater.from(parent.getContext());
          View view = inflater.inflate(layoutId, null);
          return new ContactsViewHolder(view);
      }

      @Override
      public void onBindViewHolder(ContactsViewHolder holder, int position) {
          Contact contact = contacts.get(position);
          if (position == 0 || !contacts.get(position-1).getIndex().equals(contact.getIndex())) {
              holder.tvIndex.setVisibility(View.VISIBLE);
              holder.tvIndex.setText(contact.getIndex());
          } else {
              holder.tvIndex.setVisibility(View.GONE);
          }
          holder.tvName.setText(contact.getName());
      }

      @Override
      public int getItemCount() {
          return contacts.size();
      }

      class ContactsViewHolder extends RecyclerView.ViewHolder {
          public TextView tvIndex;
          public ImageView ivAvatar;
          public TextView tvName;

          public ContactsViewHolder(View itemView) {
              super(itemView);
              tvIndex = (TextView) itemView.findViewById(R.id.tv_index);
              ivAvatar = (ImageView) itemView.findViewById(R.id.iv_avatar);
              tvName = (TextView) itemView.findViewById(R.id.tv_name);
          }
      }
     }

 ## 4. 适配器Item 布局：

  <?xml version="1.0" encoding="utf-8"?>
  <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
      android:orientation="vertical"
      android:layout_width="match_parent"
      android:layout_height="match_parent">

      <TextView
          android:id="@+id/tv_index"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:paddingLeft="12dp"
          android:text="G"
          android:textSize="14sp"
          android:background="#E0E0E0"/>

      <RelativeLayout
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:background="?android:attr/selectableItemBackground">

          <ImageView
              android:id="@+id/iv_avatar"
              android:layout_width="40dp"
              android:layout_height="40dp"
              android:layout_margin="10dp"
              android:src="@mipmap/ic_launcher"
              android:contentDescription="avatar"/>

          <TextView
              android:id="@+id/tv_name"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:layout_toRightOf="@+id/iv_avatar"
              android:text="Gjiazhe"
              android:textColor="#424242"
              android:textSize="16sp"
              android:layout_centerVertical="true" />
      </RelativeLayout>

      <View
          android:layout_width="match_parent"
          android:layout_height="1dp"
          android:background="#eee" />
  </LinearLayout>

  ![](https://github.com/sinothk/SideBar/blob/master/art/sideBar_style1.png)
