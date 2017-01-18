package org.bukkit.boss;

import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Set;

public interface BossBar {

    /**
     * Returns the title of this boss bar
     *
     * @return the title of the bar
     */
    BaseComponent getTitle();

    /**
     * Sets the title of this boss bar
     *
     * @param title the title of the bar
     */
    void setTitle(BaseComponent title);

    /**
     * Returns the color of this boss bar
     *
     * @return the color of the bar
     */
    BarColor getColor();

    /**
     * Sets the color of this boss bar.
     *
     * @param color the color of the bar
     */
    void setColor(BarColor color);

    /**
     * Returns the style of this boss bar
     *
     * @return the style of the bar
     */
    BarStyle getStyle();

    /**
     * Sets the bar style of this boss bar
     *
     * @param style the style of the bar
     */
    void setStyle(BarStyle style);

    /**
     * Replace the entire set of flags for this boss bar
     */
    void setFlags(Set<BarFlag> flags);

    /**
     * Remove an existing flag on this boss bar
     *
     * @param flag the existing flag to remove
     */
    void removeFlag(BarFlag flag);

    /**
     * Add an optional flag to this boss bar
     *
     * @param flag an optional flag to set on the boss bar
     */
    void addFlag(BarFlag flag);

    /**
     * Returns whether this boss bar as the passed flag set
     *
     * @param flag the flag to check
     * @return whether it has the flag
     */
    boolean hasFlag(BarFlag flag);

    /**
     * Sets the progress of the bar. Values should be between 0.0 (empty) and
     * 1.0 (full)
     *
     * @param progress the progress of the bar
     */
    void setProgress(double progress);

    /**
     * Returns the progress of the bar between 0.0 and 1.0
     *
     * @return the progress of the bar
     */
    double getProgress();

    /**
     * Adds the player to this boss bar causing it to display on their screen.
     *
     * @param player the player to add
     */
    void addPlayer(Player player);

    /**
     * Removes the player from this boss bar causing it to be removed from their
     * screen.
     *
     * @param player the player to remove
     */
    void removePlayer(Player player);

    /**
     * Removes all players from this boss bar
     *
     * @see #removePlayer(Player)
     */
    void removeAll();

    /**
     * Returns all players viewing this boss bar
     *
     * @return a immutable list of players
     */
    List<Player> getPlayers();

    /**
     * Set if the boss bar is displayed to attached players.
     *
     * @param visible visible status
     */
    void setVisible(boolean visible);

    /**
     * Return if the boss bar is displayed to attached players.
     *
     * @return visible status
     */
    boolean isVisible();

    /**
     * Shows the previously hidden boss bar to all attached players
     * @deprecated {@link #setVisible(boolean)}
     */
    @Deprecated
    void show();

    /**
     * Hides this boss bar from all attached players
     * @deprecated {@link #setVisible(boolean)}
     */
    @Deprecated
    void hide();

    /**
     * Set all properties of this boss bar at once. This will send no more than a single packet to
     * each client. It will be the smallest packet that can carry all the properties that actually
     * changed. If no properties change, then no packet will be sent at all.
     */
    void update(BaseComponent title, double progress, BarColor color, BarStyle style, Set<BarFlag> flags);
}
