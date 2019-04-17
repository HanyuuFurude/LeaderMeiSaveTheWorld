package com.sa.net.client.console;

import io.netty.channel.Channel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.sa.net.utils.SessionUtil;

public class ConsoleCommandManager extends ConsoleCommand {
    private Map<String, ConsoleCommand> consoleCommandMap;

    public ConsoleCommandManager() {
        consoleCommandMap = new HashMap<>();
        //consoleCommandMap.put("sendToUser", new SendToUserConsoleCommand());
     //   consoleCommandMap.put("logout", new LogoutConsoleCommand());
    }

    public void exec(Object object, Channel channel) {
        //  获取第一个指令
    	Scanner scanner = (Scanner) object;
        String command = scanner.next();

        if (!SessionUtil.hasConnected(channel)) {
            return;
        }

        ConsoleCommand consoleCommand = consoleCommandMap.get(command);

        if (consoleCommand != null) {
            consoleCommand.exec(scanner, channel);
        } else {
            System.err.println("无法识别[" + command + "]指令，请重新输入!");
        }
    }
}