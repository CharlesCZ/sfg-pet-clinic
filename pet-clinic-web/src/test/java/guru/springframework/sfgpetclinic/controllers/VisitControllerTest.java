package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.VisitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class VisitControllerTest {

@Mock
   VisitService visitService;
@Mock
    PetService petService;

@InjectMocks
VisitController visitController;

    MockMvc mockMvc;

    Pet pet;
    Set<Visit> visits=new HashSet<>();
    @BeforeEach
    void setUp() {
        visits.add(Visit.builder().id(1L).build());
        visits.add(Visit.builder().id(2L).build());
       pet = Pet.builder().id(1L).visits(visits).build();

        mockMvc= MockMvcBuilders.standaloneSetup(visitController).build();
    }




    @Test
    void initNewVisitForm() throws Exception {
        when(petService.findByID(anyLong())).thenReturn(pet);

        mockMvc.perform(get("/owners/1/pets/1/visits/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdateVisitForm"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(model().attributeExists("visit"));
    }

    @Test
    void processNewVisitForm() throws Exception {
        when(petService.findByID(anyLong())).thenReturn(pet);
when(visitService.save(any())).thenReturn(Visit.builder().id(1L).description("some string").build());

mockMvc.perform(post("/owners/1/pets/1/visits/new")
        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        .param("id","")
        .param("date","2018-11-11")
        .param("description","some string")
)
        .andExpect(status().is3xxRedirection())
        .andExpect(view().name("redirect:/owners/1"));

    }
}