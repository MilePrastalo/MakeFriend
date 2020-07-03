import { Component, OnInit } from '@angular/core';
import { Trait } from '../model/Trait';
import { UserService } from '../service/user.service';
import { AddTrait } from '../model/AddTrait';
import { InterestCategory } from '../model/InterestCategory';
import { AddCategory } from '../model/AddCategory';
import { Interest } from '../model/Interest';
import { AddInterest } from '../model/AddInterest';
import { User } from '../model/User';
import { InterestNumber } from '../model/InterestNumber';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private service: UserService) { }

  traits: Array<Trait>;
  interestCategories: Array<InterestCategory>;
  interests: Array<Interest>;
  users: Array<User>;


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
  search() {
    const min = (document.getElementById('min') as HTMLInputElement).value;
    const max = (document.getElementById('max') as HTMLInputElement).value;
    const numbers = new InterestNumber(Number(min),Number(max));
    console.log(min,max);
    this.service.getUsersByInterests(numbers).subscribe(
      response => {
        console.log(response);
        this.users = response;
      }
    );
  }
}
