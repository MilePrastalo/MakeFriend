import { Component, OnInit } from '@angular/core';
import { Trait } from '../model/Trait';
import { UserService } from '../service/user.service';
import { AddTrait } from '../model/AddTrait';
import { InterestCategory } from '../model/InterestCategory';
import { AddCategory } from '../model/AddCategory';
import { Interest } from '../model/Interest';
import { AddInterest } from '../model/AddInterest';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private service: UserService) { }

  private traits: Array<Trait>;
  private interestCategories: Array<InterestCategory>;
  private interests: Array<Interest>;

  ngOnInit(): void {
    this.service.getTraits().subscribe(
      response => {
        this.traits = response;
      },
      error => {
        console.log(error);
      }
    );
    this.service.getInterestCategories().subscribe(
      response => {
        this.interestCategories = response;
      },
      error => {
        console.log(error);
      }
    );
  }
  deleteTrait(id: number) {
    console.log(id);
    this.service.deleteTrait(id).subscribe(
      response => this.traits = response
    );
  }

  addTrait() {
    const traitName = (document.getElementById('traitName') as HTMLInputElement).value;
    const addTrait = new AddTrait(traitName);
    this.service.addTrait(addTrait).subscribe(
      response => {
        this.traits = response;
      }
    );
  }
  addCategory() {
    const categoryName = (document.getElementById('categoryName') as HTMLInputElement).value;
    const addCategory = new AddCategory(categoryName);
    this.service.addCategory(addCategory).subscribe(
      response => {
        this.interestCategories = response;
      }
    );
  }
  addInterest() {
    const interestName = (document.getElementById('interestName') as HTMLInputElement).value;
    const category = (document.getElementById('selectInterest') as HTMLSelectElement).value;
    console.log(interestName,category);
    const addInterest = new AddInterest(Number(category), interestName);
    this.service.addInterest(addInterest).subscribe(
      response => {
        this.interestCategories = response;
      }
    );
  }
}
