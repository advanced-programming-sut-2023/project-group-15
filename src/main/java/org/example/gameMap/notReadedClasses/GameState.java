package org.example.gameMap.notReadedClasses;

//import controller.NPCController;
//import controller.PlayerController;
//import core.Size;
//import entity.NPC;
//import entity.Player;
//import entity.action.Cough;
//import entity.effect.Sick;
//import input.Input;
//import map.GameMap;
//import ui.Spacing;
//import ui.UIContainer;

import org.example.gameMap.Ui.Size;
import org.example.gameMap.Ui.Spacing;
import org.example.gameMap.Ui.UIContainer;

public class GameState extends State {

    public GameState(Size windowSize) {
        super(windowSize);
//        gameMap = new GameMap(new Size(20, 20), spriteLibrary);
//        initializeCharacters();
        initializeUI();
    }

    private void initializeUI() {
        UIContainer container = new UIContainer();
        container.setPadding(new Spacing(100, 20));
        container.setMargin(new Spacing(50));
        uiContainers.add(container);
    }
//
//    private void initializeCharacters() {
//        Player player = new Player(new PlayerController(input), spriteLibrary);
//        gameObjects.add(player);
//        camera.focusOn(player);
//
//        initializeNPCs(200);
//    }
//
//    private void initializeNPCs(int numberOfNPCs) {
//        for(int i = 0; i < numberOfNPCs; i++) {
//            NPC npc = new NPC(new NPCController(), spriteLibrary);
//            npc.setPosition(gameMap.getRandomPosition());
//            npc.addEffect(new Sick());
//            gameObjects.add(npc);
//        }
//    }
}
