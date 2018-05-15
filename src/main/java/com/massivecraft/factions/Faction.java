package com.massivecraft.factions;

import com.massivecraft.factions.iface.EconomyParticipator;
import com.massivecraft.factions.iface.RelationParticipator;
import com.massivecraft.factions.struct.BanInfo;
import com.massivecraft.factions.struct.Relation;
import com.massivecraft.factions.struct.Role;
import com.massivecraft.factions.util.LazyLocation;
import com.massivecraft.factions.zcore.fperms.Access;
import com.massivecraft.factions.zcore.fperms.Permissable;
import com.massivecraft.factions.zcore.fperms.PermissableAction;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public interface Faction extends EconomyParticipator {
    HashMap<String, List<String>> getAnnouncements();

    ConcurrentHashMap<String, LazyLocation> getWarps();

    LazyLocation getWarp(String name);

    void setWarp(String name, LazyLocation loc);

    boolean isWarp(String name);

    boolean hasWarpPassword(String warp);

    boolean isWarpPassword(String warp, String password);

    void setWarpPassword(String warp, String password);

    boolean removeWarp(String name);

    void clearWarps();

    int getMaxVaults();

    void setMaxVaults(int value);

    void addAnnouncement(FPlayer fPlayer, String msg);

    void sendUnreadAnnouncements(FPlayer fPlayer);

    void removeAnnouncements(FPlayer fPlayer);

    Set<String> getInvites();

    String getId();

    void setId(String id);

    void invite(FPlayer fplayer);

    void deinvite(FPlayer fplayer);

    void setUpgrades(String key, int level);

    int getUpgrade(String key);

    boolean isInvited(FPlayer fplayer);

    void ban(FPlayer target, FPlayer banner);

    void unban(FPlayer player);

    boolean isBanned(FPlayer player);

    Set<BanInfo> getBannedPlayers();

    HashMap<Integer, String> getRulesMap();

    void setRule(int index, String rule);

    void addRule(String rule);

    void removeRule(int index);

    void clearRules();

    Location getCheckpoint();

    void setCheckpoint(Location location);

    void addTnt(int amt);

    void takeTnt(int amt);

    Location getVault();

    void setVault(Location vaultLocation);

    Inventory getChest();

    void setChest(Inventory inventory);

    void setBannerPattern(ItemStack banner);

    ItemStack getBanner();

    int getTnt();

    String getRule(int index);

    boolean getOpen();

    void setOpen(boolean isOpen);

    boolean isPeaceful();

    void setPeaceful(boolean isPeaceful);

    boolean getPeacefulExplosionsEnabled();

    void setPeacefulExplosionsEnabled(boolean val);

    boolean noExplosionsInTerritory();

    boolean isPermanent();

    void setPermanent(boolean isPermanent);

    String getTag();

    void setTag(String str);

    String getTag(String prefix);

    String getTag(Faction otherFaction);

    String getTag(FPlayer otherFplayer);

    String getComparisonTag();

    String getDescription();

    void setDescription(String value);

    boolean hasHome();

    Location getHome();

    void setHome(Location home);

    long getFoundedDate();

    void setFoundedDate(long newDate);

    void confirmValidHome();

    String getAccountId();

    Integer getPermanentPower();

    void setPermanentPower(Integer permanentPower);

    boolean hasPermanentPower();

    double getPowerBoost();

    void setPowerBoost(double powerBoost);

    boolean noPvPInTerritory();

    boolean noMonstersInTerritory();

    boolean isNormal();

    @Deprecated
    boolean isNone();

    boolean isWilderness();

    boolean isSafeZone();

    boolean isWarZone();

    boolean isPlayerFreeType();

    boolean isPowerFrozen();

    void setLastDeath(long time);

    int getKills();

    int getDeaths();

    Access getAccess(Permissable permissable, PermissableAction permissableAction);

    Access getAccess(FPlayer player, PermissableAction permissableAction);

    void setPermission(Permissable permissable, PermissableAction permissableAction, Access access);

    void resetPerms();

    Map<Permissable, Map<PermissableAction, Access>> getPermissions();

    @Override
    String describeTo(RelationParticipator that, boolean ucfirst);

    @Override
    String describeTo(RelationParticipator that);

    @Override
    Relation getRelationTo(RelationParticipator rp);

    @Override
    Relation getRelationTo(RelationParticipator rp, boolean ignorePeaceful);

    @Override
    ChatColor getColorTo(RelationParticipator rp);

    Relation getRelationWish(Faction otherFaction);

    void setRelationWish(Faction otherFaction, Relation relation);

    int getRelationCount(Relation relation);

    double getPower();

    double getPowerMax();

    int getPowerRounded();

    int getPowerMaxRounded();

    int getLandRounded();

    int getLandRoundedInWorld(String worldName);

    boolean hasLandInflation();

    void refreshFPlayers();

    boolean addFPlayer(FPlayer fplayer);

    boolean removeFPlayer(FPlayer fplayer);

    int getSize();

    Set<FPlayer> getFPlayers();

    Set<FPlayer> getFPlayersWhereOnline(boolean online);

    Set<FPlayer> getFPlayersWhereOnline(boolean online, FPlayer viewer);

    FPlayer getFPlayerAdmin();

    ArrayList<FPlayer> getFPlayersWhereRole(Role role);

    ArrayList<Player> getOnlinePlayers();

    boolean hasPlayersOnline();

    void memberLoggedOff();

    void promoteNewLeader();

    Role getDefaultRole();

    void setDefaultRole(Role role);

    void msg(String message, Object... args);

    void sendMessage(String message);

    void sendMessage(List<String> messages);

    Map<FLocation, Set<String>> getClaimOwnership();

    void clearAllClaimOwnership();

    void clearClaimOwnership(FLocation loc);

    void clearClaimOwnership(FPlayer player);

    int getCountOfClaimsWithOwners();

    boolean doesLocationHaveOwnersSet(FLocation loc);

    boolean isPlayerInOwnerList(FPlayer player, FLocation loc);

    void setPlayerAsOwner(FPlayer player, FLocation loc);

    void removePlayerAsOwner(FPlayer player, FLocation loc);

    Set<String> getOwnerList(FLocation loc);

    String getOwnerListString(FLocation loc);

    boolean playerHasOwnershipRights(FPlayer fplayer, FLocation loc);

    void remove();

    Set<FLocation> getAllClaims();
}
