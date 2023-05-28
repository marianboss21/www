package GUI;

import GUI.Drawables.PlanetStats;
import GUI.Drawables.Text;
import GUI.Drawables.Drawable;
import GUI.Drawables.Planet;
import Simulator.Values;

import java.util.ArrayList;

public class HelperFunctions {
    public static void addPlanetsToDrawables(ArrayList<PlanetStats> planetStats, ArrayList<Drawable> drawables) {
        for (int i = 0; i <= 11; i++) {
            planetStats.add(new PlanetStats(Values.NAMES[i], Values.SIZES[i], Values.COLORS[i]));

            drawables.add(new Planet(planetStats.get(i)));
        }
    }

    public static void createUIText(ArrayList<Drawable> drawables, ArrayList<Text> uiTexts) {
        Text currentDateText = new Text(GlobalState.getCenter()[0], 40, "center");
        Text daysText = new Text(GlobalState.getCenter()[0], 70, "center");
        Text simulationSpeed = new Text("left", "bottom");
        Text nameFocusedPlanet = new Text("right", "bottom");

        uiTexts.add(currentDateText);
        uiTexts.add(daysText);
        uiTexts.add(simulationSpeed);
        uiTexts.add(nameFocusedPlanet);

        for (Text text : uiTexts) {
            drawables.add(text);
        }
    }
}