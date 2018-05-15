package com.massivecraft.factions;

import com.massivecraft.factions.iface.EconomyParticipator;
import com.massivecraft.factions.iface.RelationParticipator;
import com.massivecraft.factions.struct.ChatMode;
import com.massivecraft.factions.struct.Relation;
import com.massivecraft.factions.struct.Role;
import com.massivecraft.factions.util.WarmUpUtil;
import mkremins.fanciful.FancyMessage;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public interface FPlayer extends EconomyParticipator {
    void login();

    void logout();

    Faction getFaction();

    void setFaction(Faction faction);

    String getFactionId();

    boolean hasFaction();

    boolean willAutoLeave();

    void setAutoLeave(boolean autoLeave);

    long getLastFrostwalkerMessage();

    void setLastFrostwalkerMessage();

    void setMonitorJoins(boolean monitor);

    boolean isMonitoringJoins();

    Role getRole();

    void setRole(Role role);

    boolean shouldTakeFallDamage();

    void setTakeFallDamage(boolean fallDamage);

    double getPowerBoost();

    void setPowerBoost(double powerBoost);

    Faction getAutoClaimFor();

    void setAutoClaimFor(Faction faction);

    boolean isAutoSafeClaimEnabled();

    void setIsAutoSafeClaimEnabled(boolean enabled);

    boolean isAutoWarClaimEnabled();

    void setIsAutoWarClaimEnabled(boolean enabled);

    boolean isAdminBypassing();

    boolean isVanished();

    void setIsAdminBypassing(boolean val);

    ChatMode getChatMode();

    void setChatMode(ChatMode chatMode);

    boolean isIgnoreAllianceChat();

    void setIgnoreAllianceChat(boolean ignore);

    boolean isSpyingChat();

    void setSpyingChat(boolean chatSpying);

    boolean showScoreboard();

    void setShowScoreboard(boolean show);

    String getAccountId();

    void resetFactionData(boolean doSpoutUpdate);

    void resetFactionData();

    long getLastLoginTime();

    void setLastLoginTime(long lastLoginTime);

    boolean isMapAutoUpdating();

    void setMapAutoUpdating(boolean mapAutoUpdating);

    boolean hasLoginPvpDisabled();

    FLocation getLastStoodAt();

    void setLastStoodAt(FLocation flocation);

    String getTitle();

    void setTitle(CommandSender sender, String title);

    String getName();

    String getTag();

    String getNameAndSomething(String something);

    String getNameAndTitle();

    String getNameAndTag();

    String getNameAndTitle(Faction faction);

    String getNameAndTitle(FPlayer fplayer);

    String getChatTag();

    String getChatTag(Faction faction);

    String getChatTag(FPlayer fplayer);

    int getKills();

    int getDeaths();

    void takeMoney(int amt);

    boolean hasMoney(int amt);

    boolean isInspectMode();

    void setInspectMode(boolean status);

    Boolean canflyinWilderness();

    Boolean canflyinWarzone();

    Boolean canflyinSafezone();

    Boolean canflyinEnemy();

    Boolean canflyinAlly();

    Boolean canflyinTruce();

    Boolean canflyinNeutral();

    @Override
    String describeTo(RelationParticipator that, boolean ucfirst);

    @Override
    String describeTo(RelationParticipator that);

    @Override
    Relation getRelationTo(RelationParticipator rp);

    @Override
    Relation getRelationTo(RelationParticipator rp, boolean ignorePeaceful);

    Relation getRelationToLocation();

    @Override
    ChatColor getColorTo(RelationParticipator rp);

    String getRolePrefix();
    
    void heal(int amnt);

    double getPower();

    void alterPower(double delta);

    double getPowerMax();

    double getPowerMin();

    int getPowerRounded();

    int getPowerMaxRounded();

    int getPowerMinRounded();

    void updatePower();

    void losePowerFromBeingOffline();

    void onDeath();

    boolean isInOwnTerritory();

    boolean isInOthersTerritory();

    boolean isInAllyTerritory();

    boolean isInNeutralTerritory();

    boolean isInEnemyTerritory();

    void sendFactionHereMessage(Faction from);

    void leave(boolean makePay);

    boolean canClaimForFaction(Faction forFaction);

    boolean canClaimForFactionAtLocation(Faction forFaction, Location location, boolean notifyFailure);

    boolean canClaimForFactionAtLocation(Faction forFaction, FLocation location, boolean notifyFailure);

    boolean attemptClaim(Faction forFaction, Location location, boolean notifyFailure);

    boolean attemptClaim(Faction forFaction, FLocation location, boolean notifyFailure);

    boolean isInVault();

    void setInVault(boolean status);

    void msg(String str, Object... args);

    String getId();

    void setId(String id);

    Player getPlayer();

    boolean isOnline();

    void sendMessage(String message);

    void sendMessage(List<String> messages);

    void sendFancyMessage(FancyMessage message);

    void sendFancyMessage(List<FancyMessage> message);

    int getMapHeight();

    void setMapHeight(int height);

    boolean isOnlineAndVisibleTo(Player me);

    void remove();

    boolean isOffline();

    boolean isFlying();

    void setFlying(boolean fly);

    void setFFlying(boolean fly, boolean damage);

    boolean canFlyAtLocation();

    boolean canFlyAtLocation(FLocation location);

    boolean isEnteringPassword();

    void setEnteringPassword(boolean toggle, String warp);

    String getEnteringWarp();

    boolean checkIfNearbyEnemies();

    boolean isWarmingUp();

    WarmUpUtil.Warmup getWarmupType();

    void addWarmup(WarmUpUtil.Warmup warmup, int taskId);

    void stopWarmup();

    void clearWarmup();





}
