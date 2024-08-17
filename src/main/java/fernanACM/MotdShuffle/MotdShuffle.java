/*    _       ____   __  __ 
     / \     / ___| |  \/  |
    / _ \   | |     | |\/| |
   / ___ \  | |___  | |  | |
  /_/   \_\  \____| |_|  |_|
 The creator of this plugin was fernanACM.
 https://github.com/fernanACM */

package fernanACM.MotdShuffle;

import dev.waterdog.waterdogpe.plugin.Plugin;

import fernanACM.MotdShuffle.manager.MotdManager;

public class MotdShuffle extends Plugin{

    private static MotdShuffle instance; 

    @Override
    public void onStartup(){
        instance = this;
        loadFiles();
    }

    @Override
    public void onEnable(){
        getMotdManager().init();
    }

    protected void loadFiles(){
        saveResource("config.yml");
    }

    public MotdManager getMotdManager(){
        return MotdManager.getInstance();
    }

    public static MotdShuffle getInstance(){
        return instance;
    }
}