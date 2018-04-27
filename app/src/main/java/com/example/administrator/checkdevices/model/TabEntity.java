package com.example.administrator.checkdevices.model;


import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * Created by wd on 2017/10/16.
 *
 * @author wd
 * @date 2017/10/16
 * @describe TODO
 * @package reli.kdzt.com.gongretong.model
 */

public class TabEntity implements CustomTabEntity {
    public String title;
    public int selectedIcon;
    public int unSelectedIcon;

    public TabEntity(String title, int selectedIcon, int unSelectedIcon) {
        this.title = title;
        this.selectedIcon = selectedIcon;
        this.unSelectedIcon = unSelectedIcon;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unSelectedIcon;
    }
}
