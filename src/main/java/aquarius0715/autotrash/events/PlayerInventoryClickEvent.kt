package aquarius0715.autotrash.events

import aquarius0715.autotrash.main.AutoTrash
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.Inventory

class PlayerInventoryClickEvent(private val plugin: AutoTrash): Listener {


    @EventHandler
    fun onClickcheckInv(event: InventoryClickEvent) {
        val q = event.view.title
        if ("${ChatColor.GREEN}${ChatColor.BOLD}自動削除対象アイテムの確認" == q){
            event.isCancelled = true
            return
        }
    }

    @EventHandler

    fun onClickProfileInv(event: InventoryClickEvent) {

        val q = event.view.title

        if ("${ChatColor.AQUA}${ChatColor.BOLD}プロファイル選択画面" != q)return

        val player: Player = event.whoClicked as Player

        when(event.slot) {

            11 -> {

                if (event.isLeftClick) {

                    plugin.createProfileInventory.createProfileInventoryLook(1, player)

                }

                if (event.isRightClick) {

                    plugin.createSetInventory.createSetProfileInventory(player)

                }

                if (event.isShiftClick) {

                    val materialList: MutableList<Material> = mutableListOf()

                    for (itemStack in plugin.selectProfile.selectProfile(plugin.createProfileInventory.profileMap[player.uniqueId], player)!!) {

                        materialList.add(itemStack!!.type)

                    }

                    plugin.playerMap[player.uniqueId] = materialList

                    player.sendMessage("${plugin.prefix}${ChatColor.AQUA}${ChatColor.BOLD}プロファイル${plugin.createProfileInventory.profileMap[player.uniqueId]}${ChatColor.WHITE}${ChatColor.BOLD}が選択されました。")

                    player.closeInventory()

                }

            }

            15 -> {

                if (event.isLeftClick) {

                    plugin.createProfileInventory.createProfileInventoryLook(2, player)

                }

                if (event.isRightClick) {

                    plugin.createSetInventory.createSetProfileInventory(player)

                }

                if (event.isShiftClick) {

                    val materialList: MutableList<Material> = mutableListOf()

                    for (itemStack in plugin.selectProfile.selectProfile(plugin.createProfileInventory.profileMap[player.uniqueId], player)!!) {

                        materialList.add(itemStack!!.type)

                    }

                    plugin.playerMap[player.uniqueId] = materialList

                    player.sendMessage("${plugin.prefix}${ChatColor.AQUA}${ChatColor.BOLD}プロファイル${plugin.createProfileInventory.profileMap[player.uniqueId]}${ChatColor.WHITE}${ChatColor.BOLD}が選択されました。")

                    player.closeInventory()

                }

            }

            37 -> {

                if (event.isLeftClick) {

                    plugin.createProfileInventory.createProfileInventoryLook(3, player)

                }

                if (event.isRightClick) {

                    plugin.createSetInventory.createSetProfileInventory(player)

                }

                if (event.isShiftClick) {

                    val materialList: MutableList<Material> = mutableListOf()

                    for (itemStack in plugin.selectProfile.selectProfile(plugin.createProfileInventory.profileMap[player.uniqueId], player)!!) {

                        materialList.add(itemStack!!.type)

                    }

                    plugin.playerMap[player.uniqueId] = materialList

                    player.sendMessage("${plugin.prefix}${ChatColor.AQUA}${ChatColor.BOLD}プロファイル${plugin.createProfileInventory.profileMap[player.uniqueId]}${ChatColor.WHITE}${ChatColor.BOLD}が選択されました。")

                    player.closeInventory()

                }

            }

            40 -> {

                if (event.isLeftClick) {

                    plugin.createProfileInventory.createProfileInventoryLook(4, player)

                }

                if (event.isRightClick) {

                    plugin.createSetInventory.createSetProfileInventory(player)

                }

                if (event.isShiftClick) {

                    val materialList: MutableList<Material> = mutableListOf()

                    for (itemStack in plugin.selectProfile.selectProfile(plugin.createProfileInventory.profileMap[player.uniqueId], player)!!) {

                        materialList.add(itemStack!!.type)

                    }

                    plugin.playerMap[player.uniqueId] = materialList

                    player.sendMessage("${plugin.prefix}${ChatColor.AQUA}${ChatColor.BOLD}プロファイル${plugin.createProfileInventory.profileMap[player.uniqueId]}${ChatColor.WHITE}${ChatColor.BOLD}が選択されました。")

                    player.closeInventory()

                }

            }

            43 -> {

                if (event.isLeftClick) {

                    plugin.createProfileInventory.createProfileInventoryLook(5, player)

                }

                if (event.isRightClick) {

                    plugin.createSetInventory.createSetProfileInventory(player)

                }

                if (event.isShiftClick) {

                    val materialList: MutableList<Material> = mutableListOf()

                    for (itemStack in plugin.selectProfile.selectProfile(plugin.createProfileInventory.profileMap[player.uniqueId], player)!!) {

                        materialList.add(itemStack!!.type)

                    }

                    plugin.playerMap[player.uniqueId] = materialList

                    player.sendMessage("${plugin.prefix}${ChatColor.AQUA}${ChatColor.BOLD}プロファイル${plugin.createProfileInventory.profileMap[player.uniqueId]}${ChatColor.WHITE}${ChatColor.BOLD}が選択されました。")

                    player.closeInventory()

                }

            }

        }

    }

    @EventHandler

    fun onClickProfileInvLook(event: InventoryClickEvent) {
        val q = event.view.title

        if ("${ChatColor.AQUA}${ChatColor.BOLD}プロファイル確認" != q)return
        event.isCancelled = true

        val materialList: MutableList<Material> = mutableListOf()

        val player: Player = event.whoClicked as Player

        when (event.slot) {

            12, 14 -> plugin.createProfileInventory.createProfileInventoryHub(player)

            13 -> {

                for (itemStack in plugin.selectProfile.selectProfile(plugin.createProfileInventory.profileMap[player.uniqueId], player)!!) {

                    materialList.add(itemStack!!.type)

                }

                plugin.playerMap[player.uniqueId] = materialList

                plugin.upDateProfile

                player.sendMessage("${plugin.prefix}${ChatColor.AQUA}${ChatColor.BOLD}プロファイル${plugin.createProfileInventory.profileMap[player.uniqueId]}${ChatColor.WHITE}${ChatColor.BOLD}が選択されました。")

                player.closeInventory()

            }

        }

    }

}
