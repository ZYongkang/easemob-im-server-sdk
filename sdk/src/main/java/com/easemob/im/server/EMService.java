package com.easemob.im.server;

import com.easemob.im.server.api.Context;
import com.easemob.im.server.api.DefaultContext;
import com.easemob.im.server.api.block.BlockApiV1;
import com.easemob.im.server.api.chatgroups.GroupApi;
import com.easemob.im.server.api.contact.ContactApi;
import com.easemob.im.server.api.notification.NotificationV1;
import com.easemob.im.server.api.token.TokenApiGroup;
import com.easemob.im.server.api.user.UserApi;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EMService {

    private static final Logger log = LogManager.getLogger();

    private final Context context;

    private final BlockApiV1 blockV1;

    private final ContactApi contactApi;

    private final GroupApi groupApi;

    private final NotificationV1 notificationV1;

    private final TokenApiGroup tokenApiGroup;

    private final UserApi userApi;

    public EMService(EMProperties properties) {
        printBanner();

        log.debug("EMService version: {}", EMVersion.getVersion());
        log.debug("EMService properties: {}", properties);

        this.context = new DefaultContext(properties);

        this.blockV1 = new BlockApiV1(this.context);
        this.contactApi = new ContactApi(this.context);
        this.groupApi = new GroupApi(this.context);
        this.notificationV1 = new NotificationV1(this.context);
        this.tokenApiGroup = new TokenApiGroup(this.context);
        this.userApi = new UserApi(this.context);
    }

    public BlockApiV1 blockV1() {
        return this.blockV1;
    }

    public ContactApi contact() {
        return this.contactApi;
    }

    public GroupApi group() {
        return new GroupApi(this.context);
    }

    public NotificationV1 notificationV1() {
        return this.notificationV1;
    }

    public TokenApiGroup tokenV1() {
        return this.tokenApiGroup;
    }

    public UserApi user() {
        return this.userApi;
    }



    private void printBanner() {
        String banner =
            "                                                                                            \n" +
            "            ////////\\\\      ______  ___    _____   ______  __  ___  ____    ____    ______ \n" +
            "          ///       ///    / ____/ /   |  / ___/  / ____/ /  |/  / / __ \\  / __ )  / ____/ \n" +
            "        ///  //////////   / __/   / /| |  \\__ \\  / __/   / /|_/ / / / / / / __  | / __/   \n" +
            "         ///             / /___  / ___ | ___/ / / /___  / /  / / / /_/ / / /_/ / / /___     \n" +
            "          //////////    /_____/ /_/  |_|/____/ /_____/ /_/  /_/  \\____/ /_____/ /_____/    \n" +
            "                                                                                         ";

        System.out.println(banner);
    }

}
