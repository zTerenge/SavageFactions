package com.massivecraft.factions;

import com.massivecraft.factions.zcore.persist.json.JSONBoard;
import mkremins.fanciful.FancyMessage;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.Set;


public abstract class Board {
    protected static Board instance = getBoardImpl();

    public abstract String getIdAt(FLocation flocation);

    private static Board getBoardImpl() {
        switch (Conf.backEnd) {
            case JSON:
                return new JSONBoard();
        }
        return null;
    }

    public static Board getInstance() {
        return instance;
    }

    public abstract Faction getFactionAt(FLocation flocation);

    public abstract void setIdAt(String id, FLocation flocation);

    public abstract void setFactionAt(Faction faction, FLocation flocation);

    public abstract void removeAt(FLocation flocation);

    public abstract Set<FLocation> getAllClaims(String factionId);

    public abstract Set<FLocation> getAllClaims(Faction faction);

    public abstract void clearOwnershipAt(FLocation flocation);

    public abstract void unclaimAll(String factionId);

    public abstract void unclaimAllInWorld(String factionId, World world);

    public abstract boolean isBorderLocation(FLocation flocation);

    public abstract boolean isConnectedLocation(FLocation flocation, Faction faction);

    public abstract boolean hasFactionWithin(FLocation flocation, Faction faction, int radius);

    public abstract void clean();

    public abstract int getFactionCoordCount(String factionId);

    public abstract int getFactionCoordCount(Faction faction);

    public abstract int getFactionCoordCountInWorld(Faction faction, String worldName);

    public abstract ArrayList<FancyMessage> getMap(FPlayer fPlayer, FLocation flocation, double inDegrees);

    public abstract void forceSave();

    public abstract void forceSave(boolean sync);

    public abstract boolean load();
}
