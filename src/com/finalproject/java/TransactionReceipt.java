package com.finalproject.java;

import java.util.ArrayList;
import java.util.List;

public class TransactionReceipt {
    private List<GadgetInterface> gadgetList;
    private List<WidgetInterface> largeWidgetList;
    private List<WidgetInterface> mediumWidgetList;
    private List<WidgetInterface> smallWidgetList;
    private float priceTotal;

    public TransactionReceipt(List<GadgetInterface> gadgetList) {
        this.gadgetList = new ArrayList<>();
        this.gadgetList = gadgetList;
        getWidgetList();

    }

    public void printReceipt() {
        System.out.println();
        System.out.println();
        System.out.println("Wag Corporation");
        System.out.println("~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        System.out.println("Gadget");
        printGadgets();
        System.out.println();
        printWidgets();
        System.out.println();
        printAccessories();
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        System.out.println(String.format("%-20s $%s", "Total", priceTotal));
    }

    private void getWidgetList() {
        List<WidgetInterface> widgetList = new ArrayList<>();
        largeWidgetList = new ArrayList<>();
        mediumWidgetList = new ArrayList<>();
        smallWidgetList = new ArrayList<>();

        for (GadgetInterface aGadgetList : gadgetList) {
            widgetList.addAll(aGadgetList
                    .getWidgets(aGadgetList.getColor()));
        }
        for (int i = 0; i < widgetList.size(); i++) {

            if (widgetList.get(i).getClass().getSimpleName().equals("LargeWidget")) {
                largeWidgetList.add(widgetList.get(i));
            }
            if (widgetList.get(i).getClass().getSimpleName().equals("MediumWidget")) {
                mediumWidgetList.add(widgetList.get(i));
            }
            if (widgetList.get(i).getClass().getSimpleName().equals("SmallWidget")) {
                smallWidgetList.add(widgetList.get(i));
            }
        }
    }

    private void printGadgets() {
        for (GadgetInterface aGadgetList : gadgetList) {
            String type = aGadgetList.getClass().getSimpleName();
            String color = aGadgetList.getColor().toString();
            float price = aGadgetList.getPrice();
            priceTotal += price;
            System.out.println(String.format("%s %-20s $%s", color, type, price));
        }
    }

    private void printWidgets() {
        System.out.println("Widgets");
        System.out.println("("+largeWidgetList.size()+") Large Widgets");
        System.out.println("("+mediumWidgetList.size()+") Medium Widgets");
        System.out.println("("+smallWidgetList.size()+") Small Widgets");
    }

    private void printAccessories() {
        System.out.println("Accessories");
        if (getLights() > 0) {
            System.out.println("(" + getLights() + ") Lights");
        }
        System.out.println("(" + getSwitches() + ") Switches");
        System.out.println("(" + getButtons() + ") Buttons");
        for (GadgetInterface aGadgetList : gadgetList) {
            String powersource = aGadgetList.getPowerSource();
            System.out.println(powersource);
        }
    }

    private int getLights() {
        int totalLihgts = 0;
        for (GadgetInterface aGadgetList : gadgetList) {
            totalLihgts += aGadgetList.getLights();
        }
        return totalLihgts;
    }
    private int getButtons() {
        int totalButtons = 0;
        for (GadgetInterface aGadgetList : gadgetList) {
            totalButtons += aGadgetList.getButtons();
        }
        return totalButtons;
    }
    private int getSwitches() {
        int totalSwitches = 0;
        for (GadgetInterface aGadgetList : gadgetList) {
            totalSwitches += aGadgetList.getSwitches();
        }
        return totalSwitches;
    }
}
