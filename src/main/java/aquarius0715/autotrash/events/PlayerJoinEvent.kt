package aquarius0715.autotrash.events

import aquarius0715.autotrash.main.AutoTrash
import aquarius0715.autotrash.mysql.settings.MySQLManager
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerLoginEvent
import java.io.IOException
import java.sql.ResultSet
import java.sql.SQLException

class PlayerJoinEvent(val plugin: AutoTrash): Listener {

    private val data = MySQLManager(plugin, "AutoTrash", plugin)

    @EventHandler

    fun onJoin(event: PlayerJoinEvent) {
            val p = event.player
            val uuid = p.uniqueId.toString()
            val rs: ResultSet? = data.query("SELECT * FROM AutoTrashTable WHERE UUID = '$uuid'")
            try {
                if (rs != null) {
                    if (!rs.next()) {
                        plugin.insertDefaultTable.insertDefaultTable(event.player)
                        val materialList: MutableList<Material> = mutableListOf()

                        for (count in 0..8) {

                            materialList.add(Material.AIR)

                        }

                        plugin.playerMap[event.player.uniqueId] = materialList
                    } else {
                    }
                }
            } catch (throwables: SQLException) {
                throwables.printStackTrace()
        }

    }

}