package com.liuh.expandablelistviewlearn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

/**
 * Date: 2018/3/20 15:43
 * Description:
 */

public class ExpAdapter extends BaseExpandableListAdapter {

    private String[] groupStrs;

    private String[][] childStrs;

    private Context mContext;

    public ExpAdapter(Context context, String[] groupStrs, String[][] childStrs) {
        this.mContext = context;
        this.groupStrs = groupStrs;
        this.childStrs = childStrs;
    }

    @Override
    public int getGroupCount() {
        return groupStrs.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childStrs[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupStrs[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childStrs[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    //分组和子选项是否持有稳定的id,也就是说底层数据的改变会不会影响到它们
    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewholder groupViewholder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_group, null);
            groupViewholder = new GroupViewholder();
            groupViewholder.tvGroup = convertView.findViewById(R.id.tv_group);
            convertView.setTag(groupViewholder);
        } else {
            groupViewholder = (GroupViewholder) convertView.getTag();
        }

        groupViewholder.tvGroup.setText(groupStrs[groupPosition]);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewholder childViewholder;

        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_child, null);
            childViewholder = new ChildViewholder();
            childViewholder.tvChild = convertView.findViewById(R.id.tv_child);
            convertView.setTag(childViewholder);

        } else {
            childViewholder = (ChildViewholder) convertView.getTag();
        }

        childViewholder.tvChild.setText(childStrs[groupPosition][childPosition]);
        return convertView;
    }

    //子元素是否可以被选定
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    static class GroupViewholder {
        TextView tvGroup;
    }

    static class ChildViewholder {
        TextView tvChild;
    }

}
