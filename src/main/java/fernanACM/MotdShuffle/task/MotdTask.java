/*    _       ____   __  __ 
     / \     / ___| |  \/  |
    / _ \   | |     | |\/| |
   / ___ \  | |___  | |  | |
  /_/   \_\  \____| |_|  |_|
 The creator of this plugin was fernanACM.
 https://github.com/fernanACM */

package fernanACM.MotdShuffle.task;

import dev.waterdog.waterdogpe.scheduler.Task;

import fernanACM.MotdShuffle.MotdShuffle;

public class MotdTask extends Task{
    
    public void onRun(int concurrent){
        MotdShuffle.getInstance().getMotdManager().motd();
    }

    public void onCancel(){
    }
}
