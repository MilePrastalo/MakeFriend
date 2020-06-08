import { Injectable } from '@angular/core';
import { PathService } from './path.service';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from '../model/LoginDTO';
import { Trait } from '../model/Trait';
import { AddTrait } from '../model/AddTrait';
import { InterestCategory } from '../model/InterestCategory';
import { AddCategory } from '../model/AddCategory';
import { AddInterest } from '../model/AddInterest';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private pathService: PathService, private http: HttpClient) { }

  login(login: LoginDTO): Observable<boolean> {
    return this.http.post<boolean>(this.pathService.path + '/auth/login', login);
  }

  getTraits(): Observable<Array<Trait>> {
    return this.http.get<Array<Trait>>(this.pathService.path + '/api/traits');
  }
  addTrait(aTrait: AddTrait): Observable<Array<Trait>> {
    return this.http.post<Array<Trait>>(this.pathService.path + '/api/traits', aTrait);
  }
  deleteTrait(id: number): Observable<Array<Trait>> {
    return this.http.delete<Array<Trait>>(this.pathService.path + '/api/traits/' + id);
  }
  getInterestCategories(): Observable<Array<InterestCategory>> {
    return this.http.get<Array<InterestCategory>>(this.pathService.path + '/api/interests');
  }
  addCategory(aCategory: AddCategory): Observable<Array<InterestCategory>> {
    return this.http.post<Array<InterestCategory>>(this.pathService.path + '/api/interestsCategory', aCategory);
  }
  addInterest(aInterest: AddInterest): Observable<Array<InterestCategory>> {
    return this.http.post<Array<InterestCategory>>(this.pathService.path + '/api/interests', aInterest);
  }


}
