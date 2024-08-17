/*    _       ____   __  __ 
     / \     / ___| |  \/  |
    / _ \   | |     | |\/| |
   / ___ \  | |___  | |  | |
  /_/   \_\  \____| |_|  |_|
 The creator of this plugin was fernanACM.
 https://github.com/fernanACM */

package fernanACM.MotdShuffle.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Random;

import dev.waterdog.waterdogpe.ProxyServer;

import fernanACM.MotdShuffle.MotdShuffle;
import fernanACM.MotdShuffle.task.MotdTask;

public class MotdManager{
    
    private static MotdManager instance;
    private final Random random = new Random();

    public List<String> getMessages(){
        return new ArrayList<>(MotdShuffle.getInstance().getConfig().getStringList("Settings.messages"));
    }

    public void init(){
        int time = MotdShuffle.getInstance().getConfig().getInt("Settings.delay");
        ProxyServer.getInstance().getScheduler().scheduleRepeating(new MotdTask(), time * 20);
    }

    public void motd(){
        List<String> messages = getMessages();
        if(messages.isEmpty()){
            return;
        }
        int index = random.nextInt(messages.size());
        String motd = formatMessage(messages.get(index));
        ProxyServer.getInstance().getConfiguration().setMotd(motd);
    }

    protected String formatMessage(String message){
        String prefix = MotdShuffle.getInstance().getConfig().getString("Settings.prefix");
        String maxPlayers = String.valueOf(ProxyServer.getInstance().getConfiguration().getMaxPlayerCount());
        String onlinePlayers = String.valueOf(ProxyServer.getInstance().getPlayers().size());
        String formattedMessage = message.
            replace("&", "§").
            replace("{PREFIX}", prefix).
            replace("{MAX_PLAYERS}", maxPlayers).
            replace("{ONLINE_PLAYERS}", onlinePlayers);
        return formattedMessage;
    }

    public static MotdManager getInstance(){
        if(instance == null) instance = new MotdManager();
        return instance;
    }
}
