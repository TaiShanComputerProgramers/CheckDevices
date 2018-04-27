package com.example.administrator.checkdevices.interfaces;

import com.example.administrator.checkdevices.updateversion.UpdateAppBean;

/**
 * Created by wd on 2018/4/13.
 *
 * @author wd
 * @date 2018/4/13
 * @describe TODO
 * @package com.example.administrator.checkdevices.interfaces
 */

public interface IUpdateDialogFragmentListener {
    /**
     * 当默认的更新提示框被用户点击取消的时候调用
     * @param updateApp
     */
    void onUpdateNotifyDialogCancel(UpdateAppBean updateApp);
}
