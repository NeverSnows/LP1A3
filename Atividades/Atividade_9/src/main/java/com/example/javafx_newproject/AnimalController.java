package com.example.javafx_newproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AnimalController implements Initializable {
    private List<Animal> animalsList;
    @FXML
    private TextArea animalDescriptionDisplay;

    @FXML
    private ComboBox<String> animalsComboBox;

    @FXML
    void updateAnimalDescriptionDisplay(ActionEvent event) {
        Animal selectedAnimal = animalsList.get(animalsComboBox.getSelectionModel().getSelectedIndex());

        animalDescriptionDisplay.setText("Name: " + selectedAnimal.getName() +
                "\nAge: " + selectedAnimal.getAge() +
                "\nType: " + selectedAnimal.getFormatedType() +
                "\nDescription: " + selectedAnimal.getDescription());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        animalDescriptionDisplay.setWrapText(true);
        animalsList = new ArrayList<>();
        createTestData();

        for(Animal animal : animalsList){
            animalsComboBox.getItems().add(animal.getName());
        }
    }

    private void createTestData(){
        animalsList.add(new Animal(12, "Rogerin", "Rogerionho é brabo. N mexe com ele.", AnimalType.GOAT));
        animalsList.add(new Animal(2, "Marcelinho", "Marcelinho é um peixe fantoche, que possui como trabalho ler contos heroticos para a internet, com um tom ironico, em seu canal no YouTube.", AnimalType.FISH));
        animalsList.add(new Animal(7, "Neil", "Neil era um gato gordo, muito preguiçoso e peculiar. Ele gostava de ficar na dele, mas não vivia sem compania.", AnimalType.CAT));
        animalsList.add(new Animal(4, "Luan", "Foi um gato extremamente carete e que adorava colo. O gato mais peludo e fofo que ja vi.", AnimalType.CAT));
        animalsList.add(new Animal(45, "Marcelo", "Marcelo é um homem de meia idade desempregado que mora no porão da mãe e faz videos para o TikTok mostrando buracos na jurisdição. Atualmente possui uma recompensa em sua cabeça, por conta de seu alter ego na internet \"Marcelão do balão\". Seu nome esta sujo na receita federal e ele possui 3 crianças iranianas trabalhando forçadamente sobre sua tutela, amarradas ao lado de seu guarda roupa. Se vir Marcelo, corra e chame a policia, pois provavelmente ele estará sobre o efeito de entorpecentes.", AnimalType.HUMAN));
    }
}
