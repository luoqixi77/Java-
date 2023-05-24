package com.darling.utils;

import java.util.ArrayList;
import java.util.List;

public class CUtil {

    public static List<Information> toTree(List<Information> treeList, Integer mPid) {
        List<Information> retList = new ArrayList<Information>();
        for (Information parent : treeList) {
            if (mPid.equals(parent.getPid())) {
                retList.add(findChildren(parent, treeList));
            }
        }
        return retList;
    }
    private static Information findChildren(Information parent, List<Information> treeList) {
        for (Information child : treeList) {
            if (parent.getId().equals(child.getPid())) {
                if (parent.getChild() == null) {
                    parent.setChild(new ArrayList<>());
                }
                parent.getChild().add(findChildren(child, treeList));
            }
        }
        return parent;
    }
}
